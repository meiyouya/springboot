package com.zql.mybatisplus.service.impl;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zql.mybatisplus.entity.ResourceLock;
import com.zql.mybatisplus.mapper.MysqlLockMapper;
import com.zql.mybatisplus.service.MysqlLockService;
import com.zql.mybatisplus.util.IpUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

/**
 * @author lawliet.L
 */
@Service
public class MysqlLockServiceImpl extends ServiceImpl<MysqlLockMapper, ResourceLock> implements MysqlLockService {

    /**
     * 加锁
     * 一定要加事务，因为排它锁是在 commit 的时候释放的
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean lock(String resourceName) {
        ResourceLock lockInfo = baseMapper.getBlockLockInfo(resourceName);
        if (ObjectUtil.isNotEmpty(lockInfo)) {
            // 有锁
            if (IpUtils.getClientIp().equalsIgnoreCase(lockInfo.getNodeInfo())) {
                // 如果是来自同一个ip，重入次数加1即可
                if (baseMapper.addLockCount(resourceName) > 0) {
                    return true;
                }
            }
        } else {
            // 无锁，插入新的锁
            ResourceLock resourceLock = new ResourceLock();
            resourceLock.setNodeInfo(IpUtils.getClientIp());
            resourceLock.setCreateDate(LocalDate.now());
            resourceLock.setResourceName(resourceName);
            resourceLock.setDesc(resourceName + "的锁");
            if (baseMapper.insert(resourceLock) > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 加锁
     *
     * @param resourceName 资源名称
     * @param timeout      超时时间设置
     * @return 获取锁的结果
     */
    @Override
    public boolean lock(String resourceName, long timeout) {
        long timeoutTimestamp = System.currentTimeMillis() + timeout;
        while (true) {
            if (this.lock(resourceName)) {
                return true;
            }
            if (System.currentTimeMillis() > timeoutTimestamp) {
                // 超时则加锁失败
                return false;
            }
        }
    }

    /**
     * 释放锁
     *
     * @param resourceName 资源名
     * @return 释放结果
     */
    @Override
    public boolean unlock(String resourceName) {
        return false;
    }

}
