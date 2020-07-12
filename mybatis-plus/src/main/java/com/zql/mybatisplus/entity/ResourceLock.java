package com.zql.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author lawliet.L
 */
@Data
@TableName("t_resource_lock")
public class ResourceLock {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer Id;

    private String resourceName;

    private Integer count;

    private String nodeInfo;

    private String desc;

    private LocalDate createDate;

    private LocalDate updateDate;
}
