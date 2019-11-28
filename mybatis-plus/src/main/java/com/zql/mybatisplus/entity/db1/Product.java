package com.zql.mybatisplus.entity.db1;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@TableName("t_ms_product")
@Data
public class Product extends Model<Product> {

    @TableId
    private Integer id;

    private String name;
}
