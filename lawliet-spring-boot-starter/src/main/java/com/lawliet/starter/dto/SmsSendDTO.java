package com.lawliet.starter.dto;

import lombok.Data;

@Data
public class SmsSendDTO {

    /**
     * 模板id
     */
    private String templateId;

    /**
     * 参数
     */
    private String param;

    /**
     * 手机号
     */
    private String mobile;
}
