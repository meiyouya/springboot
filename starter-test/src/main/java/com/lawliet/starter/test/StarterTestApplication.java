package com.lawliet.starter.test;

import com.lawliet.starter.SmsService;
import com.lawliet.starter.dto.SmsSendDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class StarterTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarterTestApplication.class, args);
    }

    @Autowired
    private SmsService smsService;

    @GetMapping("/send")
    public String sendSms() {
        SmsSendDTO smsSendDTO = new SmsSendDTO();
        // 设置手机号
        smsSendDTO.setMobile("");
        // 设置模板
        smsSendDTO.setTemplateId("");
        // 设置参数
        smsSendDTO.setParam("");
        return smsService.sendSMS(smsSendDTO);
    }
}
