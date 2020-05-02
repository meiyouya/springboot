package com.zql.mybatisplus.util;

import cn.hutool.extra.servlet.ServletUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lawliet.L
 */
public class IpUtils {

    /**
     * 获取当前线程的request的ip
     * @return
     */
    public static String getClientIp() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return getClientIpByRequest(request);
    }

    /**
     * 根据指定request获取ip
     * @param request
     * @return
     */
    public static String getClientIpByRequest(HttpServletRequest request) {
        return ServletUtil.getClientIP(request);
    }
}
