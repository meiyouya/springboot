package com.zql.springbootannotation.annotation;

import java.lang.annotation.*;

/**
 * 日志
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyLog {

    String value() default "日志记录";
}
