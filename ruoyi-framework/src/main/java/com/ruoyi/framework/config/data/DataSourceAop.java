package com.ruoyi.framework.config.data;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataSourceAop {

    @Before("execution(* com.ruoyi.system.mapper.*.*(..))")
    public void setDataSource1() {
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.ds1);
    }

    @Before("execution(* com.ruoyi.post.mapper.*.*(..))")
    public void setDataSource2() {
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.ds2);
    }

    @Before("execution(* com.ruoyi.company.mapper.*.*(..))")
    public void setDataSource3() {
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.ds3);
    }
}
