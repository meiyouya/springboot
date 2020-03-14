package com.zql.springboot.redis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author lawliet.L
 */
public class JedisUtils {

    private static JedisPool jedisPool = new JedisPool();

    public static boolean setnx(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis == null) {
                return false;
            }
            String res = jedis.set(key, value, "NX", "EX", 60);
            System.out.println(res);
            return "ok".equalsIgnoreCase(res);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;
    }
}
