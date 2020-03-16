package com.zql.springboot.redis.util;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * @author lawliet.L
 */
@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 获取锁
     * @param key 锁的唯一key
     * @param value 锁的到期时间的毫秒值
     * @return 获取是否成功
     */
    public boolean lock(String key, String value) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        if (valueOperations.setIfAbsent(key, value)) {
            // 锁成功
            return true;
        }

        // 获取当前值
        String currentVal = valueOperations.get(key);

        // 上一个锁已过期，才可以继续获取锁
        if (StrUtil.isNotEmpty(currentVal) && Long.parseLong(currentVal) < System.currentTimeMillis()) {
            // 如果多个线程同时进到这里，使用getAndSet方法可以避免多个线程获取到同一个锁，因为getAndSet方法必须是一个一个执行
            String oldVal = valueOperations.getAndSet(key, value);
        }
        return false;
    }
}
