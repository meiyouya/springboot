package com.zql.mybatisplus.entity.db2;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class UserDb2 {

    @TableId
    private long id;
    private String username;
    private String password;
    private String nickname;
}
