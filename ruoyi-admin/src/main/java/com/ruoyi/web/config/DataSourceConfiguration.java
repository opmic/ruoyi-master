package com.ruoyi.web.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhangyugu
 * @Date 2020/9/12 5:49 下午
 * @Version 1.0
 */
@Configuration
@MapperScan(basePackages = {"com.learn.springboot.mapper"})
public class DataSourceConfiguration {

//    @Value("${spring.datasource.druid.defaultDs}")
//    private String defaultDs;

//    @Bean("dataSourceMaster")
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
//    public DataSource dataSourceMaster() {
//        DataSource druidDataSource = DruidDataSourceBuilder.create().build();
////        DbContextHolder.addDataSource("master", druidDataSource);
//        return druidDataSource;
//    }
//
//    @Bean("dataSourceSlave")
//    @ConfigurationProperties(prefix = "spring.datasource.druid.slave")
//    public DataSource dataSourceSlave() {
//        DataSource druidDataSource = DruidDataSourceBuilder.create().build();
////        DbContextHolder.addDataSource("slave", druidDataSource);
//        return druidDataSource;
//    }

//    @Bean("dynamicRoutingDataSource")
//    public DynamicRoutingDataSource dataSource(@Qualifier("dataSourceMaster") DataSource dataSourceMaster, @Qualifier("dataSourceSlave") DataSource dataSourceSlave) {
//        DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
//        Map<Object, Object> targetDataSources = new HashMap<>();
//        targetDataSources.put("master", dataSourceMaster);
//        targetDataSources.put("slave", dataSourceSlave);
//
//        dynamicRoutingDataSource.setDefaultTargetDataSource(dataSourceMaster);
//        dynamicRoutingDataSource.setTargetDataSources(targetDataSources);
////        DbContextHolder.setDefaultDs(defaultDs);
//        return dynamicRoutingDataSource;
//    }

//    @Bean(name = "transactionManager")
//    public DataSourceTransactionManager transactionManager(DynamicRoutingDataSource dynamicRoutingDataSource) {
//        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dynamicRoutingDataSource);
//        return transactionManager;
//    }

}
