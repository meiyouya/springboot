package com.zql.springbootannotation.interceptor;

import com.zql.springbootannotation.annotation.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author lawliet.L
 */
@Component
public class ResultInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            Method method = handlerMethod.getMethod();
            // 下面的反射可以做缓存避免每次请求都要去反射影响性能
            if (clazz.isAnnotationPresent(Result.class)) {
                request.setAttribute("result", clazz.getAnnotation(Result.class));
            } else if (method.isAnnotationPresent(Result.class)) {
                request.setAttribute("result", method.getAnnotation(Result.class));
            }
        }
        return true;
    }
}
