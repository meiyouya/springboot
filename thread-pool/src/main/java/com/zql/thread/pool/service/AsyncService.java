package com.zql.thread.pool.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author lawliet.L
 */
@Service
public class AsyncService {

    @Async
    public void executeTask(int i) {
        System.out.println("线程名：" + Thread.currentThread().getName() + "，参数：" + i);
    }

    @Async
    public Future<String> executeWithReturn(int i) {
        return new AsyncResult<>("您传递的参数时：" + i);
    }
}
