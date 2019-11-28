package com.zql.springbootannotation.filter;

import com.zql.springbootannotation.annotation.Login;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;

public class LoginFilter implements HandlerMethodArgumentResolver {

    /**
     * 返回是否需要对参数进行处理，返回true会执行resolveArgument方法
     * 返回false直接结束
     * @param methodParameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(Login.class);     // 有注解的就需要处理参数
    }

    /**
     * 处理参数
     * @param methodParameter
     * @param modelAndViewContainer
     * @param nativeWebRequest
     * @param webDataBinderFactory
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String authorization = request.getHeader("Authorization");
        String result = null;
        Login login = null;
        if (authorization != null) {
            Annotation[] parameterAnnotations = methodParameter.getParameterAnnotations();
            for (Annotation annotation : parameterAnnotations) {
                if (annotation instanceof Login) {
                    login = (Login) annotation;
                    break;
                }
            }

            if (login != null) {
                // TODO 获取请求参数中的token赋值给result
            }
        }
        return result;
    }
}
