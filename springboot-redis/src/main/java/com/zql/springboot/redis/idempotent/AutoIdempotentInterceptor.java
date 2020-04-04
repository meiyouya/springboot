package com.zql.springboot.redis.idempotent;

import cn.hutool.json.JSONUtil;
import com.zql.springboot.redis.bean.Result;
import com.zql.springboot.redis.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @author lawliet.L
 */
@Component
@Slf4j
public class AutoIdempotentInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        AutoIdempotent autoIdempotent = method.getAnnotation(AutoIdempotent.class);
        if (autoIdempotent != null) {
            try {
                return tokenService.checkToken(request);
            } catch (BusinessException e) {
                log.error("校验token发生异常", e);
                returnCheckFailMessage(response, Result.fail(e.getMessage()));
                return false;
            }
        }
        return true;
    }

    /**
     * 返回校验失败的信息
     * @param response
     * @param result
     */
    private void returnCheckFailMessage(HttpServletResponse response, Result result) {
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            writer = response.getWriter();
            writer.print(JSONUtil.toJsonStr(result));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
