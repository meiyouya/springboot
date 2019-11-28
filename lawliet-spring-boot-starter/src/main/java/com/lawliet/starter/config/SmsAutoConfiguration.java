package com.lawliet.starter.config;

import com.lawliet.starter.SmsService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lawliet.L
 */
@Configuration
@EnableConfigurationProperties(SmsProperties.class)
public class SmsAutoConfiguration {

    @Bean
    public SmsService getBean(SmsProperties properties) {
        return new SmsService(properties);
    }
}
