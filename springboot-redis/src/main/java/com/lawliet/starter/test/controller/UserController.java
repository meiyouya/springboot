package com.lawliet.starter.test.controller;

import com.lawliet.starter.test.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/info")
    @Cacheable(value = "user-key")  // value的值是缓存到redis中的key
    public User getUserInfo() {
        User user = new User();
        user.setUsername("lisi");
        user.setPassword("456");
        return user;
    }

    @GetMapping("/uid")
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        return session.getId();
    }
}
