package com.zql.springboot.redis.service;

/**
 * @author lawliet.L
 */
public interface GrabService {

    /**
     * 抢单
     * @param u
     * @return
     */
    boolean grab(String u);
}
