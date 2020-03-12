package com.zql.springbootannotation.annotation;

import java.lang.annotation.*;

/**
 * @author lawliet.L
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface Result {

}
