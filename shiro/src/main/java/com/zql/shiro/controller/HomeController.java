package com.zql.shiro.controller;

import cn.hutool.core.util.StrUtil;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HomeController {

    /**
     * 登陆
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) {
        // 登陆的逻辑shiro内部已经实现，所以这里只需要处理登录结果，登录结果存放在request中的shiroLoginFailure中
        String exception = (String) request.getAttribute("shiroLoginFailure");
        String msg = "";
        if (StrUtil.isNotEmpty(exception)) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                msg = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "账号或密码不正确";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                msg = "验证码错误";
            } else {
                msg = exception;
            }
        }
        map.put("msg",msg);
        return "login";
    }

    /**
     * 无权限页面
     * @return
     */
    @RequestMapping("/403")
    public String unauthorized() {
        return "403";
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping({"/","/index"})
    public String index() {
        return "index";
    }
}
