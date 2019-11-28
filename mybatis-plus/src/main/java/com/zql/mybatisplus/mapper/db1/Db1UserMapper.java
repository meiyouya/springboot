package com.zql.mybatisplus.mapper.db1;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zql.mybatisplus.entity.db1.UserDb1;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Db1UserMapper extends BaseMapper<UserDb1> {

    UserDb1 selectUserById(int id);
}
