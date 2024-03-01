package com.ruoyi.web.core.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 自定义元数据对象处理器（创建时间&修改时间）
 * @Author: 文君
 * @Date: 2023-06-20-10:46
 * @Description:
 */
@Component
public class MymetaObjecthandler implements MetaObjectHandler {
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 插入自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //自动填充【insert】
        metaObject.setValue("createTime", LocalDateTime.now());
    }

    /**
     * 插入自动更新
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        metaObject.setValue("updateTime", LocalDateTime.now());
    }
}