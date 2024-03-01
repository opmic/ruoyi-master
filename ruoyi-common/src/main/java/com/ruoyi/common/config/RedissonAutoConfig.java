package com.ruoyi.common.config;



import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: RedissonAutoConfig
 * Description:
 * date: 2023/7/18 20:16
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Configuration
@ConditionalOnClass(Config.class)
@EnableConfigurationProperties(RedissonProperties.class)
public class RedissonAutoConfig {
    private static final Logger log = LoggerFactory.getLogger(RedissonAutoConfig.class);

    @Autowired
    private RedissonProperties redssionProperties;

    /**
     * 单机模式自动装配
     *
     * @return
     */
    @Bean
    RedissonClient redissonSingle() {
        log.info("init RedissonClient.redissonSingle()...");
        Config config = new Config();
        String host = redssionProperties.getHost();
        String port = redssionProperties.getPort();
        String address = "";
        if (StringUtils.isNotBlank(host) && StringUtils.isNotBlank(port)) {
            address = "redis://" + host + ":" + port;
        }
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(address)
                .setTimeout(Math.toIntExact(redssionProperties.getTimeout().getSeconds()))
                .setConnectionPoolSize(redssionProperties.getConnectionPoolSize())
                .setConnectionMinimumIdleSize(redssionProperties.getConnectionMinimumIdleSize())
                .setDatabase(redssionProperties.getDatabase());

        if (StringUtils.isNotBlank(redssionProperties.getPassword())) {
            serverConfig.setPassword(redssionProperties.getPassword());
        }
        //解决存储乱码问题
        config.setCodec(new JsonJacksonCodec());
        return Redisson.create(config);
    }

}
