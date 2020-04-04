package com.zql.springboot.redis.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author lawliet.L
 */
@AllArgsConstructor
@Builder
@Getter
public class BusinessException extends Exception {

    private int code;
    private String message;
}
