package com.ruoyi.common.annotation;

import java.lang.annotation.*;
import java.sql.Connection;

/**
 * ClassName: TransactionMulti
 * Description:
 * date: 2023/6/29 20:58
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface TransactionMulti {
    String[] value() default {};
    int transactionType() default Connection.TRANSACTION_READ_UNCOMMITTED;
}