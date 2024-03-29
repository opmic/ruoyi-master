package com.ruoyi.web.config;



import com.ruoyi.common.annotation.TransactionMulti;
import com.ruoyi.web.datasource.DynamicDataSourceRegister;
import com.ruoyi.web.datasource.DynamicRoutingDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

@Aspect
@Component
@Slf4j
public class MultiTransactionManagerAop {

    private DynamicRoutingDataSource dataSourceRouting = new DynamicRoutingDataSource();


    @Pointcut("@annotation(com.ruoyi.common.annotation.TransactionMulti)")
    public void annotationPointcut(){}


    @Around("annotationPointcut()")
    public Object roundExecute(ProceedingJoinPoint joinpoint) throws Throwable {
       // Object[] args = joinpoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) joinpoint.getSignature();
        Method method = methodSignature.getMethod();
        TransactionMulti annotation = method.getAnnotation(TransactionMulti.class);
        String[] values = annotation.value();
        int transactionType = annotation.transactionType();
        //把涉及到的连接绑定到线程上,开启事务,关闭自动提交
        begin(values, transactionType);
        //正真执行了 方法
        Object proceed = joinpoint.proceed();
        //commit

        dataSourceRouting.doCommit();

        //Object result = joinpoint.proceed(args);
        //logger.info("响应结果为{}",result);
        //如果这里不返回result，则目标对象实际返回值会被置为null
        return proceed;
    }

    @AfterThrowing(pointcut = "annotationPointcut()",throwing = "e")
    public void handleThrowing(JoinPoint joinPoint, Exception e) {//controller类抛出的异常在这边捕获
        try {
            dataSourceRouting.rollback();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }



    private void begin(String[] values,int transactionType) throws SQLException {
        for (String value : values) {
            DataSource dataSource = DynamicDataSourceRegister.getDataSource(value);
            if(dataSource == null){
                log.error("没有找到数据源:{}", value);
                continue;
            }
            Connection connection = dataSource.getConnection();
            prepareTransactionalConnection(connection,transactionType);
            connectBegin(connection);
            //绑定到线程上面
            dataSourceRouting.bindConnection(value, connection);
        }
    }

    /**
     * 开启事物的一些准本工作
     */
    private void connectBegin(Connection connection) throws SQLException {
        if(connection!=null){
            try {
                if(connection.getAutoCommit()){
                    connection.setAutoCommit(false);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    /**
     * 设置隔离级别
     * @param con
     * @throws SQLException
     */
    protected void prepareTransactionalConnection(Connection con,int transactionType)
            throws SQLException {
        if (TransactionTypeEnum.isNotDefined(transactionType)){
            throw new SqlSessionException("当前事物隔离级别未被定义");
        }
        con.setTransactionIsolation(transactionType);
    }

}
