package com.zql.rabbitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloSender1 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String message = "hello " + new Date();
        rabbitTemplate.convertAndSend("hello",message);
    }

    public void send(String i) {
        rabbitTemplate.convertAndSend("hello",i);
    }
}
