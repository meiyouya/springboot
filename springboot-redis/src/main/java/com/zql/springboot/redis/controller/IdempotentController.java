package com.zql.springboot.redis.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.zql.springboot.redis.bean.Result;
import com.zql.springboot.redis.idempotent.AutoIdempotent;
import com.zql.springboot.redis.idempotent.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author lawliet.L
 */
@RestController
@AllArgsConstructor
@RequestMapping("/idempotent")
public class IdempotentController {

    private final TokenService tokenService;

    @GetMapping("/token")
    public Result getToken() {
        String token = tokenService.createToken();
        return StrUtil.isNotEmpty(token) ? Result.success(token) : Result.fail("获取失败");
    }

    @AutoIdempotent
    @GetMapping("/test")
    public Result testIdempotent() {
        return Result.success(RandomUtil.randomString(6));
    }
}
