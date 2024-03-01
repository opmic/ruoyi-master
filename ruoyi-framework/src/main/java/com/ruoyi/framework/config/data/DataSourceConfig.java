package com.ruoyi.framework.config.data;

import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * ClassName: DataSourceConfig
 * Description:
 * date: 2023/6/29 11:06
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
//@Configuration
public class DataSourceConfig {
    /**
     * 创建多个数据源 ds1 和 ds2
     * @return
     */

    @Primary
    @Bean(name = "ds1")
    @ConfigurationProperties(prefix = "spring.datasource.ds1")
    public DataSource getDateSource1(Environment env) {
        //return DataSourceBuilder.create().build();
        return getDataSource(env,"spring.datasource.ds1.","ds1");
    }
    @Bean(name = "ds2")
    @ConfigurationProperties(prefix = "spring.datasource.ds2")
    public DataSource getDateSource2(Environment env) {
        //return DataSourceBuilder.create().build();
        return getDataSource(env,"spring.datasource.ds2.","ds2");
    }
    @Bean(name = "ds3")
    @ConfigurationProperties(prefix = "spring.datasource.ds3")
    public DataSource getDateSource3(Environment env) {
        //return DataSourceBuilder.create().build();
        return getDataSource(env,"spring.datasource.ds3.","ds3");
    }
    public DataSource getDataSource(Environment env, String prefix, String dataSourceName){
        Properties prop = build(env,prefix);
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setXaDataSourceClassName(MysqlXADataSource.class.getName());
        ds.setUniqueResourceName(dataSourceName);
        ds.setXaProperties(prop);
        return ds;
    }

    protected Properties build(Environment env, String prefix) {
        Properties prop = new Properties();
        System.out.println(prefix);
        System.out.println(env.getProperty(prefix + "url"));
        System.out.println(env.getProperty(prefix + "username"));
        System.out.println(env.getProperty(prefix + "password"));
        prop.put("url", env.getProperty(prefix + "url"));
        prop.put("user", env.getProperty(prefix + "username"));
        prop.put("password", env.getProperty(prefix + "password"));
        // prop.put("driverClassName", env.getProperty(prefix + "driverClassName", ""));
        return prop;
    }

    @Bean(name = "sqlSessionFactory1")
    @Primary
    public SqlSessionFactory sqlSessionFactory1(@Qualifier("ds1") DataSource dataSource)throws Exception {
        return createSqlSessionFactory(dataSource);
    }

    @Bean(name = "sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory2(@Qualifier("ds2") DataSource dataSource)throws Exception {
        return createSqlSessionFactory(dataSource);
    }
    @Bean(name = "sqlSessionFactory3")
    public SqlSessionFactory sqlSessionFactory3(@Qualifier("ds3") DataSource dataSource)throws Exception {
        return createSqlSessionFactory(dataSource);
    }
    /**
     * 将多个数据源注入到DynamicDataSource
     * @param dataSource1
     * @param dataSource2
     * @return
     */
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource DataSource(@Qualifier("ds1") DataSource dataSource1,
                                        @Qualifier("ds2") DataSource dataSource2, @Qualifier("ds3") DataSource dataSource3) {
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSourceType.DataBaseType.ds1, dataSource1);
        targetDataSource.put(DataSourceType.DataBaseType.ds2, dataSource2);
        targetDataSource.put(DataSourceType.DataBaseType.ds3, dataSource3);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(dataSource1);
        return dataSource;
    }

    @Bean(name = "sqlSessionTemplate")
    public CustomSqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory1")SqlSessionFactory factory1,
                                                       @Qualifier("sqlSessionFactory2")SqlSessionFactory factory2,
                                                       @Qualifier("sqlSessionFactory3")SqlSessionFactory factory3) throws Exception {
        Map<Object,SqlSessionFactory> sqlSessionFactoryMap = new HashMap<>();
        sqlSessionFactoryMap.put("ds1",factory1);
        sqlSessionFactoryMap.put("ds2",factory2);
        sqlSessionFactoryMap.put("ds3",factory3);
        CustomSqlSessionTemplate customSqlSessionTemplate = new CustomSqlSessionTemplate(factory1);
        customSqlSessionTemplate.setTargetSqlSessionFactorys(sqlSessionFactoryMap);
        customSqlSessionTemplate.setDefaultTargetSqlSessionFactory(factory1);
        return customSqlSessionTemplate;
    }

    /**
     * 将动态数据源注入到SqlSessionFactory
     * @param
     * @return
     * @throws Exception
     */
    /*@Bean(name = "SqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/*.xml"));
        bean.setTypeAliasesPackage("cn.youyouxunyin.multipledb2.entity");
        return bean.getObject();
    }*/
    private SqlSessionFactory createSqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setVfs(SpringBootVFS.class);
        bean.setTypeAliasesPackage(" com.ruoyi.**.domain,com.ruoyi.**.entity");
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session
                .Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/**/*Mapper.xml"));
        return bean.getObject();
    }
}
