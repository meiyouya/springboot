package com.zql.springboot.log.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dell
 */
@RestController
@Slf4j
@RequestMapping("/index")
public class IndexController {

    @GetMapping
    public String index() {
        log.debug("debug log");
        log.info("info log");
        log.error("error log");
        return "Hello";
    }
}
