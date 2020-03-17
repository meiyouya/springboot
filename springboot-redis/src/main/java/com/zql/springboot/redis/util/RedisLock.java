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
            // 如果多个线程同时进到这里，使用getAndSet方法可以避免多个线程获取到同一个锁
            String oldVal = valueOperations.getAndSet(key, value);

            // 假设两个线程同时进来这里，因为key被占用了，而且锁过期了。获取的值currentValue=A(get取的旧的值肯定是一样的),
            // 两个线程的value都是B,key都是K.锁时间已经过期了。
            // 而这里面的getAndSet一次只会一个执行，也就是一个执行之后，上一个的value已经变成了B。
            // 只有一个线程获取的上一个值会是A，另一个线程拿到的值是B
            if (StrUtil.isNotEmpty(oldVal) && oldVal.equals(currentVal)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 释放锁
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {
        try {
            ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
            String currentValue = valueOperations.get(key);
            if (StrUtil.isNotEmpty(currentValue) && currentValue.equals(value)) {
                valueOperations.getOperations().delete(key);
            }
        }catch (Exception e) {
            log.error("解锁异常", e);
        }
    }
}
