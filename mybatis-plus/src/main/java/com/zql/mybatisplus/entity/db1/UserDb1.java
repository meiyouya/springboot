package com.zql.mybatisplus.entity.db1;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class UserDb1 {

    @TableId
    private int id;
    private String username;
    private String password;
}
