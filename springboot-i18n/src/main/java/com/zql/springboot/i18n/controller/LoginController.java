package com.zql.springboot.i18n.controller;

import com.zql.springboot.i18n.bean.UserVO;
import com.zql.springboot.i18n.locale.LocaleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lawliet.L
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LocaleMessage localeMessage;

    @GetMapping
    public UserVO login() {
        UserVO userVO = new UserVO();
        userVO.setTitle(localeMessage.getMessage("user.title"));
        userVO.setWelcomeWord(localeMessage.getMessage("user.welcome"));
        userVO.setUsername(localeMessage.getMessage("user.username"));
        userVO.setPassword(localeMessage.getMessage("user.password"));
        userVO.setSignInWord(localeMessage.getMessage("user.login"));
        return userVO;
    }
}
