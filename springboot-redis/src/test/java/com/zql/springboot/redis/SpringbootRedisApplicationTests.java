package com.zql.springboot.redis;

import cn.hutool.core.lang.UUID;
import com.zql.springboot.redis.entity.User;
import com.zql.springboot.redis.util.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisService redisService;

    /**
     * 操作字符串
     */
    @Test
    public void test01() {
        stringRedisTemplate.opsForValue().set("aaa","111");
        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));   // 输出 111
    }

    /**
     * 操作对象
     */
    @Test
    public void test02() {
        User user = new User();
        user.setUsername("zhang");
        user.setPassword("123");
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("user",user);
        ops.set("user",user,1, TimeUnit.MINUTES);
        if (redisTemplate.hasKey("user")) {
            System.out.println(ops.get("user"));    // 输出 User(username=zhang, password=123)
        } else {
            System.out.println("user不存在");
        }
    }

    @Test
    public void test03() {
        System.out.println(redisTemplate.opsForValue().get("user-key"));
    }

    @Test
    public void test04() throws InterruptedException {
//        System.out.println(redisService.set("key", "value"));
        System.out.println(redisService.setKeyAndExpire("key2", "value2", 1L));
        System.out.println(redisService.get("key2"));
//        System.out.println(redisService.setExpire("key", 1L));
//        System.out.println(redisService.get("key"));
        Thread.sleep(2000);
        System.out.println(redisService.get("key2"));
    }

}
