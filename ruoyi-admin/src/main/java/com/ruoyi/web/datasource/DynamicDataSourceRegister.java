package com.ruoyi.web.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.boot.context.properties.source.ConfigurationPropertyNameAliases;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源注册
 * 实现 ImportBeanDefinitionRegistrar 实现数据源注册
 * 实现 EnvironmentAware 用于读取application.yml配置
 */
@Slf4j
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {


    /**
     * 配置上下文（也可以理解为配置文件的获取工具）
     */
    private Environment evn;

    /**
     * 别名
     */
    private final static ConfigurationPropertyNameAliases aliases = new ConfigurationPropertyNameAliases();

    /**
     * 由于部分数据源配置不同，所以在此处添加别名，避免切换数据源出现某些参数无法注入的情况
     */
    static {
        aliases.addAliases("url", new String[]{"jdbc-url"});
        aliases.addAliases("username", new String[]{"user"});
    }

    /**
     * 存储我们注册的数据源
     */
    private static final Map<String, DataSource> customDataSources = new HashMap<String, DataSource>();

    /**
     * 参数绑定工具 springboot2.0新推出
     */
    private Binder binder;

    /**
     * ImportBeanDefinitionRegistrar接口的实现方法，通过该方法可以按照自己的方式注册bean
     *
     * @param annotationMetadata
     * @param beanDefinitionRegistry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        // 获取数据源配置
        Map config = (Map)binder.bind("spring.datasource.druid.master", Map.class).get().get("0");
        registerDataSource(config);

        config = (Map)binder.bind("spring.datasource.druid.slave", Map.class).get().get("0");
        registerDataSource(config);
        config = (Map)binder.bind("spring.datasource.druid.slave1", Map.class).get().get("0");
        registerDataSource(config);
        // bean定义类
        GenericBeanDefinition define = new GenericBeanDefinition();
        // 设置bean的类型，此处DynamicRoutingDataSource是继承AbstractRoutingDataSource的实现类
        define.setBeanClass(DynamicRoutingDataSource.class);
        // 需要注入的参数
        MutablePropertyValues mpv = define.getPropertyValues();
        // 添加默认数据源，避免key不存在的情况没有数据源可用
        mpv.add("defaultTargetDataSource", customDataSources.get("master"));
        // 添加其他数据源
        mpv.add("targetDataSources", customDataSources);
        // 将该bean注册为datasource，不使用springboot自动生成的datasource
        beanDefinitionRegistry.registerBeanDefinition("datasource", define);
        log.info("注册数据源成功，一共注册{}个数据源", customDataSources.keySet().size());
    }

    private DataSourceTransactionManager registerDataSource(Map config) {
        // 绑定参数
        DataSource consumerDatasource = bind(getDataSourceType((String) config.get("type")), config);
//      //设置事务
        DataSourceTransactionManager secondDataSourceTransactionManager = new DataSourceTransactionManager();
        secondDataSourceTransactionManager.setDataSource(consumerDatasource);

        // 获取数据源的key，以便通过该key可以定位到数据源
        String key = config.get("key").toString();
        customDataSources.put(key, consumerDatasource);
        // 数据源上下文，用于管理数据源与记录已经注册的数据源key
        DynamicDataSourceContextHolder.dataSourceIds.add(key);
        log.info("注册数据源{}成功", key);

        return secondDataSourceTransactionManager;
    }

    public static DataSource getDataSource(String key){
        return customDataSources.get(key);
    }


    /**
     * 通过字符串获取数据源class对象
     *
     * @param typeStr
     * @return
     */
    private Class<? extends DataSource> getDataSourceType(String typeStr) {
        Class<? extends DataSource> type;
        try {
            if (StringUtils.hasLength(typeStr)) {
                // 字符串不为空则通过反射获取class对象
                type = (Class<? extends DataSource>) Class.forName(typeStr);
            } else {
                // 默认为hikariCP数据源，与springboot默认数据源保持一致
                type = DruidDataSource.class;
            }
            return type;
        } catch (Exception e) {
            throw new IllegalArgumentException("can not resolve class with type: " + typeStr); //无法通过反射获取class对象的情况则抛出异常，该情况一般是写错了，所以此次抛出一个runtimeexception
        }
    }

    /**
     * 绑定参数，以下三个方法都是参考DataSourceBuilder的bind方法实现的，目的是尽量保证我们自己添加的数据源构造过程与springboot保持一致
     *
     * @param result
     * @param properties
     */
    private void bind(DataSource result, Map properties) {
        ConfigurationPropertySource source = new MapConfigurationPropertySource(properties);
        Binder binder = new Binder(new ConfigurationPropertySource[]{source.withAliases(aliases)});
        // 将参数绑定到对象
        binder.bind(ConfigurationPropertyName.EMPTY, Bindable.ofInstance(result));
    }

    private <T extends DataSource> T bind(Class<T> clazz, Map properties) {
        ConfigurationPropertySource source = new MapConfigurationPropertySource(properties);
        Binder binder = new Binder(new ConfigurationPropertySource[]{source.withAliases(aliases)});
        // 通过类型绑定参数并获得实例对象
        return binder.bind(ConfigurationPropertyName.EMPTY, Bindable.of(clazz)).get();
    }

    /**
     * @param clazz
     * @param sourcePath 参数路径，对应配置文件中的值，如: spring.datasource
     * @param <T>
     * @return
     */
    private <T extends DataSource> T bind(Class<T> clazz, String sourcePath) {
        Map properties = binder.bind(sourcePath, Map.class).get();
        return bind(clazz, properties);
    }

    /**
     * EnvironmentAware接口的实现方法，通过aware的方式注入，此处是environment对象
     *
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {
        log.info("开始注册数据源");
        this.evn = environment;
        // 绑定配置器
        binder = Binder.get(evn);
    }


 /*   @Bean(name = "mysqlDataSource")
    public DataSource mysqlDataSource() {
        getDataSourceType("")
        return ;
    }*/


  /*  @Bean(name = "icspdbSessionFactory")
    // @Qualifier表示查找Spring容器中名字为test1DataSource的对象
    public SqlSessionFactory test2SqlSessionFactory(@Qualifier("mysqlDataSource") DataSource datasource)
            throws Exception {

        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(datasource);

        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setCallSettersOnNulls(true);
        configuration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
        configuration.setMapUnderscoreToCamelCase(false);
        bean.setConfiguration(configuration);


        bean.setMapperLocations(
                // 设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }*/
}