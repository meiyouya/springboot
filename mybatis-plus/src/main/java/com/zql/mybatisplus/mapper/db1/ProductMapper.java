package com.zql.mybatisplus.mapper.db1;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zql.mybatisplus.entity.db1.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper extends BaseMapper<Product> {

    Product selectById(@Param("id") int id);
}
