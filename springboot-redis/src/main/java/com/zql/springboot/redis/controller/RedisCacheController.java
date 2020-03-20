package com.zql.springboot.redis.controller;

import com.zql.springboot.redis.bean.Result;
import com.zql.springboot.redis.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dell
 */
@RestController
@RequestMapping("/cache")
@Slf4j
public class RedisCacheController {

    @GetMapping("/user")
    @Cacheable(cacheNames = "user", key = "'name'")
    public Result<User> user() {
        log.info("查询user");
        return Result.success(new User("张三", "123"));
    }
}
