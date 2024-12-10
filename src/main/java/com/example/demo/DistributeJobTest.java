package com.example.demo;

import org.redisson.api.CronSchedule;
import org.redisson.api.RScheduledExecutorService;
import org.redisson.api.RedissonClient;
import org.redisson.api.WorkerOptions;
import org.redisson.codec.Kryo5Codec;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 *  * @author fht
 *   * @since 2024-08-06 12:49
 *    */
@Component
public class DistributeJobTest implements ApplicationRunner {

    private final BeanFactory beanFactory;
    private final RedissonClient redissonClient;

    public DistributeJobTest(BeanFactory beanFactory, RedissonClient redissonClient) {
        this.beanFactory = beanFactory;
        this.redissonClient = redissonClient;
    }

    @Override
    public void run(ApplicationArguments args) {
        WorkerOptions workerOptions = WorkerOptions
            .defaults()
            .workers(4)
            .beanFactory(beanFactory);
        RScheduledExecutorService executorService = redissonClient.getExecutorService("demo", new Kryo5Codec());
        executorService.registerWorkers(workerOptions);
        executorService.schedule("demo", new DistributeJobTask(), CronSchedule.of("*/2 * * * * ?"));
    }
}

