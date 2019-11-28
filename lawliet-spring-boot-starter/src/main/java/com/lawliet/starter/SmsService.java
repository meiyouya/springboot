package com.lawliet.starter;

import com.alibaba.fastjson.JSONObject;
import com.lawliet.starter.config.SmsProperties;
import com.lawliet.starter.dto.SmsSendDTO;
import com.lawliet.starter.enums.ENUM_SMS_API_URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * @author lawliet.L
 */
public class SmsService {

    @Autowired
    private RestTemplate restTemplate;
    private String appId;
    private String accountSid;
    private String authToken;

    /**
     * 初始化
     */
    public SmsService(SmsProperties properties) {
        this.appId = properties.getAppId();
        this.accountSid = properties.getAccountSid();
        this.authToken = properties.getAuthToken();
    }

    /**
     * 发送单挑
     * @param smsSendDTO 发送信息实体
     * @return String
     */
    public String sendSMS(SmsSendDTO smsSendDTO) {
        return restTemplate.postForObject(ENUM_SMS_API_URL.SEND_SMS.getUrl(), initSendParam(smsSendDTO), String.class);
    }

    /**
     * 批量发送信息
     * @param smsSendDTO 发送信息实体
     * @return String
     */
    public String sendBatchSMS(SmsSendDTO smsSendDTO) {
        return restTemplate.postForObject(ENUM_SMS_API_URL.SEND_BATCH_SMS.getUrl(), initSendParam(smsSendDTO), String.class);
    }

    /**
     * 初始化发送参数
     * @param smsSendDTO 发送信息实体
     */
    private HttpEntity initSendParam(SmsSendDTO smsSendDTO) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sid", accountSid);
        jsonObject.put("token", authToken);
        jsonObject.put("appId", appId);
        jsonObject.put("templateId", smsSendDTO.getTemplateId());
        jsonObject.put("mobile", smsSendDTO.getMobile());
        jsonObject.put("param", smsSendDTO.getParam());

        String json = JSONObject.toJSONString(jsonObject);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new HttpEntity<>(json, headers);
    }
}
