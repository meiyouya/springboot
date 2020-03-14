package com.zql.springboot.redis.service.impl;

import com.zql.springboot.redis.service.GrabService;
import org.springframework.stereotype.Service;

/**
 * @author lawliet.L
 */
@Service
public class GrabServiceImpl implements GrabService {

    /**
     * 模拟初始化库存
     */
    int stock = 10;

    /**
     * 初始化抢单超时时间，单位秒
     */
    int timeout = 30;

    /**
     * 抢单
     *
     * @param u 用户名
     * @return 抢单结果
     */
    @Override
    public boolean grab(String u) {

        return false;
    }
}
