package com.zql.mybatisplus.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kotlin")
class KotlinController {

    @GetMapping("/hello")
    fun hello(): String {
        return "在Java项目中混合使用kotlin进行开发";
    }
}