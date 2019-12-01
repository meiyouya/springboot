package com.zql.mybatisplus.controller;

import com.zql.mybatisplus.entity.WsUser;
import com.zql.mybatisplus.mapper.SSHMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dell
 */
@RestController
@AllArgsConstructor
public class SSHController {

    private final SSHMapper sshMapper;

    @GetMapping("/ssh")
    public String get() {
        WsUser user = sshMapper.selectById(1);
        return user.toString();
    }
}
