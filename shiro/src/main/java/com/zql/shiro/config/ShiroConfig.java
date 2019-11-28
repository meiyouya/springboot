package com.zql.shiro.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author lawliet.L
 */
@Configuration
public class ShiroConfig {

    /**
     * 过滤器
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean factory = new ShiroFilterFactoryBean();
        factory.setSecurityManager(securityManager);    // 设置权限管理器

        // 添加jwt过滤器
        HashMap<String, Filter> jwtFilter = new HashMap<>();
        jwtFilter.put("jwt",jwtFilter());
        jwtFilter.put("logout",new SystemLogoutFilter());

        // 拦截器配置
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();    // 拦截器集合
        // 拦截器的匹配会按照配置的顺序匹配，匹配到了，就不会向后匹配了，所以越精确的匹配越要放在前面
        filterMap.put("/static/**","anon");     // 静态资源不鉴权
        filterMap.put("/logout","logout");      // 退出过滤器，shiro内部已经实现了退出的代码

        // 配置权限过滤
        filterMap.put("/user/add/**","perms[user:add]");
        // 配置权限过滤
        filterMap.put("/user/del/**","roles[admin],perms[user:del]");


        filterMap.put("/**","authc");       // 剩下的URL，全部需要鉴权
        factory.setFilterChainDefinitionMap(filterMap);

        factory.setLoginUrl("/login");      // 设置登录的url

        factory.setSuccessUrl("/index");    // 登录成功后跳转的url

        factory.setUnauthorizedUrl("/403");     // 无权限跳转的URL

        return factory;
    }

    /**
     * 权限管理器
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm());
        return securityManager;
    }

    /**
     * 自定义realm
     * @return
     */
    @Bean
    public MyRealm myRealm() {
        return new MyRealm();
    }

    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter();
    }
}
