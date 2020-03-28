package com.zql.springboot.i18n.controller;

import com.zql.springboot.i18n.locale.LocaleMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lawliet.L
 */
@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @Resource
    private LocaleMessage localeMessage;

    @GetMapping
    public String welcome() {
        return localeMessage.getMessage("welcome");
    }
}
