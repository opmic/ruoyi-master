package com.ruoyi.web.config;


import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.web.datasource.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Author zhangyugu
 * @Date 2020/9/13 9:56 上午
 * @Version 1.0
 */
@Aspect
@Component
@Order(1)
@Slf4j
public class MapperAspect {

    @Pointcut("@annotation(com.ruoyi.common.annotation.DataSource)"
            + "|| @within(com.ruoyi.common.annotation.DataSource)")
    public void pointCut(){
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        DataSource annotation = getDataSource(joinPoint);

        String dsId = annotation == null ? "master" : annotation.value();
        log.info("选择数据源:{}", dsId);
        DynamicDataSourceContextHolder.setDataSourceRouterKey(dsId);
    }
    public DataSource getDataSource(JoinPoint point)
    {
        MethodSignature signature = (MethodSignature) point.getSignature();
        DataSource dataSource = AnnotationUtils.findAnnotation(signature.getMethod(), DataSource.class);
        if (Objects.nonNull(dataSource))
        {
            return dataSource;
        }

        return AnnotationUtils.findAnnotation(signature.getDeclaringType(), DataSource.class);
    }
    private DataSource getDataSourceAnnotation(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        DataSource annotation = method.getAnnotation(DataSource.class);
        if(annotation!=null) {
            return annotation;
        }

        Class<?>[] interfaces = joinPoint.getTarget().getClass().getInterfaces();
        for(Class<?> anInterface: interfaces) {
            annotation = anInterface.getAnnotation(DataSource.class);
            if(annotation!=null) {
                return annotation;
            }
        }
        return null;
    }

    @After("pointCut()")
    public void after() {
        DynamicDataSourceContextHolder.removeDataSourceRouterKey();
    }
}
