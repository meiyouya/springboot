package com.zql.springboot.redis.idempotent;

import java.lang.annotation.*;

/**
 * 自动幂等注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AutoIdempotent {
}
