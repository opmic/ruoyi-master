package com.ruoyi.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.Duration;

/**
 * ClassName: RedissonProperties
 * Description:
 * date: 2023/7/18 20:15
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@ConditionalOnProperty("spring.redis.password")
@Setter
@Getter
@Primary
public class RedissonProperties {
    private Duration timeout;

    private String host;

    private String port;

    private String password;

    private int database;

    private int connectionPoolSize = 64;

    private int connectionMinimumIdleSize = 10;

    private int slaveConnectionPoolSize = 250;

    private int masterConnectionPoolSize = 250;

    private String[] sentinelAddresses;

    private String masterName;
}
