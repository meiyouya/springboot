package com.zql.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @RequestMapping("/info")
    public String userInfo() {
        return "userInfo";
    }

    @RequestMapping("/add")
    public String userAdd() {
        return "userInfoAdd";
    }

    @RequestMapping("/del")
    public String userDel() {
        return "userInfoDel";
    }
}
