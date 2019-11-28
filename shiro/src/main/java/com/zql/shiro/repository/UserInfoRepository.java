package com.zql.shiro.repository;

import com.zql.shiro.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {

    UserInfo findByUsername(String username);
}
