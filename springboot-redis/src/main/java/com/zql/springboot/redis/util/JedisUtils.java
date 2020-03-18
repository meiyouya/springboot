package com.zql.springboot.redis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author lawliet.L
 */
public class JedisUtils {

    private static JedisPool jedisPool = new JedisPool();

    /**
     * 获取锁
     * @param key
     * @param value
     * @return
     */
    public static boolean setnx(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis == null) {
                return false;
            }
            String res = jedis.set(key, value, "NX", "EX", 60);
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

    /**
     * 释放锁
     * @param key
     * @param value
     * @return
     */
    public static int delnx(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis == null) {
                return 0;
            }

            StringBuilder delScript = new StringBuilder();
            delScript.append("if redis.call('get','").append(key).append("')").append("=='").append(value).append("'")
                    .append("then")
                    .append("  return redis.call('del','").append(key).append("')")
                    .append("else")
                    .append("  return 0")
                    .append(" end");
            return Integer.parseInt(jedis.eval(delScript.toString()).toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return 0;
    }
}
