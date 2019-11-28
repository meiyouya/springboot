package com.zql.thread.pool.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author lawliet.L
 */
@Service
public class AsyncService {

    @Async
    public void executeTask(int i) {
        System.out.println("线程名：" + Thread.currentThread().getName() + "，参数：" + i);
    }

}
