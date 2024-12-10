package com.example.demo;

import org.redisson.client.codec.StringCodec;
import org.redisson.spring.starter.RedissonAutoConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 *  * @author fht
 *   * @since 2024-08-06 13:34
 *    */
@Configuration
public class RedisConfiguration {
    @Bean
    public RedissonAutoConfigurationCustomizer stringCodecRedissonAutoConfigurationCustomizer() {
        return config -> {
            config.setCodec(StringCodec.INSTANCE);
        };
    }

    @Bean
    public RedissonAutoConfigurationCustomizer virtualThreadsRedissonAutoConfigurationCustomizer() {
        return config -> {
            ThreadFactory factory = Thread.ofVirtual().name("redisson-", 0).factory();
            ExecutorService executor = Executors.newThreadPerTaskExecutor(factory);
            config.setExecutor(executor);
        };
    }
}

