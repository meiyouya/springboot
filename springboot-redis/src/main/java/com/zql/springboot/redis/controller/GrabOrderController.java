package com.zql.springboot.redis.controller;

import com.zql.springboot.redis.service.GrabService;
import com.zql.springboot.redis.util.JedisUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author lawliet.L
 */
@RestController
@RequestMapping("/grab")
@AllArgsConstructor
public class GrabOrderController {

    private final GrabService grabService;

    @GetMapping("/nx")
    public boolean nx(String key, String value) {
        return JedisUtils.setnx(key, value);
    }

    @GetMapping("/grab")
    public List<String> grab() {

        // 模拟10万个用户
        ArrayList<String> users = new ArrayList<>();
        IntStream.range(0, 100000).parallel().forEach(u -> {
            users.add("客户--" + u);
        });

        // 存储抢到单的用户
        ArrayList<String> grabUserList = new ArrayList<>();

        // 使用parallelStream并行开抢
        users.parallelStream().forEach(u -> {
            if (grabService.grab(u)) {
                grabUserList.add(u);
            }
        });
        return grabUserList;
    }
}
