package com.zql.springbootannotation.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LogAspect {

    private final Logger log = LoggerFactory.getLogger(getClass());

    // 定义切点
    @Pointcut("@annotation(com.zql.springbootannotation.annotation.MyLog)")
    private void cut() {}

    /**
     * 环绕通知
     * @param joinPoint
     */
    @Around("cut()")    // 参数指定切点
    public void advice(ProceedingJoinPoint joinPoint) {
        log.info("环绕通知之开始通知");
        try {
            joinPoint.proceed();    // 执行本应该执行的
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info("环绕通知之结束通知");
    }

    /**
     * 前置通知
     */
    /*@Before("cut()")
    public void before() {
        log.info("前置通知");
    }*/

    /**
     * 后置通知
     */
    /*@After("cut()")
    public void after() {
        System.out.println("后置通知");
    }*/
}
