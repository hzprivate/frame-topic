package com.hz.springnginx.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * Created by 郑皓 on 2016/4/29.
 */
@Component
@ComponentScan(basePackages="com.nbaisino.dzfp.thread")
public class ThreadPoolConf {
    @Bean
    public ThreadPoolTaskExecutor ThreadPoolConf(){
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(10);
        pool.setMaxPoolSize(50);
        pool.setQueueCapacity(100);
        pool.setKeepAliveSeconds(100);
        pool.setWaitForTasksToCompleteOnShutdown(true);
        return pool;
    }
}
