package com.zql.springboot.redis.controller;

import com.zql.springboot.redis.bean.Result;
import com.zql.springboot.redis.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    @Cacheable(cacheNames = "user", key = "'name'") // cacheNames相当于一个命名空间，cacheNames::key构成了整个redis值得key，
    // key赋值的时候一定要加单引号才可以声明为字符串,如果整个类下的所有东西都要缓存，并且命名空间应用，可以在类上使用@CacheConfig(cacheNames="xxx")来指定
    // 类中的方法就只需通过@Cacheable指定key就可以了
    public Result<User> user() {
        log.info("查询user");
        return Result.success(new User("张三", "123"));
    }


    @DeleteMapping("/user")
    @CacheEvict(cacheNames = "user", key = "'name'")    // 删除缓存
    public Result<Boolean> removeUserCache() {
        log.info("删除缓存");
        return Result.success(true);
    }


    @GetMapping("/username")
    // key可以使用表达式，#用于取参数或者返回值，condition字段用于标识满足该条件才缓存，与其相反的是unless，用于标识满足该条件的都不缓存
    @Cacheable(cacheNames = "user", key = "#username", condition = "#result.getCode() == 200")
    public Result<User> getByUsername(String username) {
        log.info("根据用户名查询用户");
        return Result.success(new User(username, "123"));
    }
}
