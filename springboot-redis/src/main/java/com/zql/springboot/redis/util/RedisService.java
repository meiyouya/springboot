package com.zql.springboot.redis.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 在redis中存值
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {
            log.error("redis设置值异常", e);
            return false;
        }
        return true;
    }

    /**
     * 在redis中存值并设置有效期
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    public boolean setKeyAndExpire(String key, Object value, Long seconds) {
        try {
            redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("redis设置值异常", e);
            return false;
        }
        return true;
    }

    /**
     * 设置已存值的有效期
     * @param key
     * @param seconds
     * @return
     */
    public boolean setExpire(String key, Long seconds) {
        try {
            redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("redis设置有效期异常", e);
            return false;
        }
        return true;
    }

    /**
     * 读取缓存的值
     * @param key
     * @return
     */
    public Object get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 判断redis中是否有该缓存
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除缓存
     * @param key
     * @return
     */
    public boolean remove(final String key) {
        return exists(key) ? redisTemplate.delete(key) : false;
    }
}
