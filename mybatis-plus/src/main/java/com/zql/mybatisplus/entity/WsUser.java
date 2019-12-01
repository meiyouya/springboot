package com.zql.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dell
 */
@TableName("t_ws_user")
@Data
public class WsUser implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer departmentId;
    private Integer postId;
    private Integer securityClassificationId;
    private String userName;
    private String password;
    private String slat;
    private String status;
    private Date createDate;
    private Date updateDate;
    private String tenantId;
    private String remark;
    private String type;
    private int delFlag;
    private Integer createBy;
    private Integer updateBy;
    private int sex;
    private String phone;
    private Date loginTime;
    private String loginProvince;
    private String loginCity;
    private Date lastLoginTime;
    private String uid;




}
