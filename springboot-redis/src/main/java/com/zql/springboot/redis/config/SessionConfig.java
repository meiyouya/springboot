package com.zql.springboot.redis.config;

import org.springframework.context.annotation.Configuration;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author lawliet.L
 */
@Configuration
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 30 * 60) // 设置session失效时间，使用了redis session之后，原来的server.session.timeout将会失效
public class SessionConfig {
}
