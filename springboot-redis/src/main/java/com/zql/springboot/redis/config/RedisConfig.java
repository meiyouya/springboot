package com.zql.springboot.redis.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching  // 开启缓存
public class RedisConfig extends CachingConfigurerSupport {

    @Override
    @Bean
    public KeyGenerator keyGenerator() {
        return (o,method,objects) -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(o.getClass().getName());
            stringBuilder.append(method.getName());
            for (Object object : objects) {
                stringBuilder.append(object.toString());
            }
            return stringBuilder.toString();
        };
    }
}
