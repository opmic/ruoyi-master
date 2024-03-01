package com.ruoyi.common.lock;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName: OrderLock
 * Description:
 * date: 2023/7/18 20:03
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@AllArgsConstructor
@Getter
public enum OrderLock {
    DIVIDE_INTO("divide_into",5,4);
    private String lock;
    private  long waitTime;
    private long leaseTime;
}
