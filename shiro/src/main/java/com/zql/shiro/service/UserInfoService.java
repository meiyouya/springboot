package com.zql.shiro.service;

import com.zql.shiro.entity.UserInfo;

public interface UserInfoService {

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);
}
