package com.lawliet.starter.test.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lawliet.L
 */
@RestController
@RequestMapping("/grab")
@AllArgsConstructor
public class GrabOrderController {

    private final RedisTemplate redisTemplate;

    @GetMapping
    public String grab() {
        return "";
    }
}
