package com.zql.springbootannotation.controller;

import com.zql.springbootannotation.annotation.MyLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/hi")
    @MyLog
    public String hello() {
        return "Hello";
    }
}
