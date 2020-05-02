package com.zql.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zql.mybatisplus.entity.ResourceLock;

/**
 * Mysql分布式锁工具类
 * @author lawliet.L
 */
public interface MysqlLockService extends IService<ResourceLock> {

    /**
     * 加锁
     * @param resourceName 资源名称
     * @return 获取锁的结果
     */
    boolean lock(String resourceName);

    /**
     * 加锁
     * @param resourceName 资源名称
     * @param timeout 超时时间设置
     * @return 获取锁的结果
     */
    boolean lock(String resourceName, long timeout);

    /**
     * 释放锁
     * @param resourceName 资源名
     * @return 释放结果
     */
    boolean unlock(String resourceName);
}
