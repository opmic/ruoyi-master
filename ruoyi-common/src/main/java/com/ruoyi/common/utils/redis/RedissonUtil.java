package com.ruoyi.common.utils.redis;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: RedissonUtil
 * Description:
 * date: 2023/7/18 20:23
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Component
public class RedissonUtil {

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 锁住不设置超时时间
     *
     * @param lockKey
     * @return org.redisson.api.RLock
     */
    public RLock lock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock();
        return lock;
    }

    /**
     * leaseTime为加锁时间，单位为秒
     *
     * @param lockKey
     * @param leaseTime
     * @return org.redisson.api.RLock
     */
    public RLock lock(String lockKey, long leaseTime) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(leaseTime, TimeUnit.SECONDS);
        return null;
    }

    /**
     * timeout为加锁时间，时间单位由unit确定
     *
     * @param lockKey
     * @param unit
     * @param timeout
     * @return org.redisson.api.RLock
     */
    public RLock lock(String lockKey, TimeUnit unit, long timeout) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(timeout, unit);
        return lock;
    }

    /**
     * 尝试获取锁（时间属性：秒）
     *
     * @param lockKey
     * @param waitTime
     * @param leaseTime
     */
    public boolean tryLock(String lockKey, long waitTime, long leaseTime) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(waitTime, leaseTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            return false;
        }
    }

    /**
     * 尝试获取锁
     *
     * @param lockKey
     * @param unit
     * @param waitTime
     * @param leaseTime
     */
    public boolean tryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(waitTime, leaseTime, unit);
        } catch (InterruptedException e) {
            return false;
        }
    }

    /**
     * 通过lockKey解锁
     *
     * @param lockKey
     */
    public void unlock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.unlock();
    }

    /**
     * 直接通过锁解锁
     */
    public void unlock(RLock lock) {
        lock.unlock();
    }
}
