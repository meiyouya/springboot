package com.zql.mybatisplus.mapper.db2;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zql.mybatisplus.entity.db1.UserDb1;
import com.zql.mybatisplus.entity.db2.UserDb2;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Db2UserMapper extends BaseMapper<UserDb2> {

    UserDb2 selectUserById(int id);
}
