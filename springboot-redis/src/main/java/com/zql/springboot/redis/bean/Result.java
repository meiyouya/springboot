package com.zql.springboot.redis.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author dell
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    public static <T> Result<T> success(T data) {
        return Result.<T>builder().code(200).msg("操作成功").data(data).build();
    }

    public static <T> Result<T> fail(String message) {
        return Result.<T>builder().code(0).msg(message).build();
    }
}
