package com.zql.mybatisplus.controller;


import com.zql.mybatisplus.entity.db1.UserDb1;
import com.zql.mybatisplus.entity.db2.UserDb2;
import com.zql.mybatisplus.mapper.db1.Db1UserMapper;
import com.zql.mybatisplus.mapper.db2.Db2UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lawliet
 * @since 2019-04-20
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final Db1UserMapper db1UserMapper;
    private final Db2UserMapper db2UserMapper;

    @GetMapping("/db1/{id}")
    public UserDb1 getDb1(@PathVariable("id") int id) {
        return db1UserMapper.selectUserById(id);
    }

    @GetMapping("/db2/{id}")
    public UserDb2 getDb2(@PathVariable("id") int id) {
        return db2UserMapper.selectUserById(id);
    }
}
