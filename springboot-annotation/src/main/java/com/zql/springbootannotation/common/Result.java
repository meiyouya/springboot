package com.zql.springbootannotation.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author lawliet.L
 */
@AllArgsConstructor
public class Result<T> {

    @Setter
    @Getter
    private int code;
    @Setter
    @Getter
    private String message;
    @Setter
    @Getter
    private T data;

    public static <T> Result success(T data) {
        return new Result<>(200, "操作成功", data);
    }

    public static <T> Result fail(T data) {
        return new Result<>(500, "操作失败", data);
    }
}
