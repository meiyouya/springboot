package com.zql.springboot.redis.service.impl;

import com.zql.springboot.redis.service.GrabService;
import com.zql.springboot.redis.util.JedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author lawliet.L
 */
@Service
@Slf4j
public class GrabServiceImpl implements GrabService {

    /**
     * 模拟初始化库存
     */
    int stock = 10;

    /**
     * 初始化抢单超时时间，单位毫秒
     */
    int timeout = 30 * 1000;

    /**
     * 抢购商品的id
     */
    int id = 123;

    /**
     * 抢单
     *
     * @param u 用户名
     * @return 抢单结果
     */
    @Override
    public boolean grab(String u) {
        // 用户进入抢单的时间
        long start = System.currentTimeMillis();

        // 未超时就可以继续获取锁
        while ((start + timeout) >= System.currentTimeMillis()) {
            // 抢完了
            if (stock <= 0) {
                log.info("活动太火爆，抢完了");
                break;
            }

            // 获取锁
            if (JedisUtils.setnx(Integer.toString(id), u)) {
                log.info("用户：{}，拿到锁", u);
                try {
                    // 抢完了
                    if (stock <= 0) {
                        log.info("活动太火爆，抢完了");
                        break;
                    }

                    // 模拟下单操作
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // 抢购成功，库存-1
                    stock = stock - 1;
                    log.info("用户{}抢购成功", u);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 释放锁
                    JedisUtils.delnx(Integer.toString(id), u);
                }
            }
        }
        return false;
    }
}
