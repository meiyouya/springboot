package com.zql.docker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DockerController {

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        return "Hello docker,I am from " + request.getRemoteAddr();
    }
}
