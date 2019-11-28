package com.zql.rabbitmq;

import com.zql.rabbitmq.sender.HelloSender1;
import com.zql.rabbitmq.sender.HelloSender2;
import com.zql.rabbitmq.sender.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private HelloSender2 helloSender2;
    @Autowired
    private TopicSender topicSender;

    @Test
    public void contextLoads() {
        helloSender1.send();
    }

    @Test
    public void oneToMany() {
        for (int i=0;i<100;i++){
            helloSender1.send(String.valueOf(i));
        }
    }

    @Test
    public void manyToMany() {
        for (int i=0;i<100;i++){
            helloSender1.send(String.valueOf(i));
            helloSender2.send(String.valueOf(i));
        }
    }

}
