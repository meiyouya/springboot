package com.lawliet.starter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lawliet.L
 */
@Data
@ConfigurationProperties(prefix = "sms-config")
public class SmsProperties {

    private String appId;
    private String accountSid;
    private String authToken;
}
