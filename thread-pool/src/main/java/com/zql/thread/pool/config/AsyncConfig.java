package com.zql.thread.pool.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author lawliet.L
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数，一般动态设置为CPU核心数
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        // 最大线程数，对于IO密集型操作，如数据库交互，文件上传下载，网络传输等操作，设置为CPU核心数*2
        // 对于CPU密集型操作，如复杂点的算法，一般设置为CPU核心数+1
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * 2);
        // 等待队列
        executor.setQueueCapacity(25);
        // 如果执行数超过最大线程数，调用者的线程会执行该任务，一般的并发情况不需要这个参数
        // taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 配置线程池中的线程名的前缀，默认为ThreadPoolTaskExecutor - x
        executor.setThreadNamePrefix("thread-name-");
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
