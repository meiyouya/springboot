package com.lawliet.starter.enums;

import lombok.Getter;

/**
 * @author lawliet.L
 */

@Getter
public enum ENUM_SMS_API_URL {
    /**
     * 短信发送
     */
    SEND_SMS("https://open.ucpaas.com/ol/sms/sendsms"),
    /**
     * 短信批量发送
     */
    SEND_BATCH_SMS("https://open.ucpaas.com/ol/sms/sendsms_batch");

    private String url;

    ENUM_SMS_API_URL(String url) {
        this.url = url;
    }
}
