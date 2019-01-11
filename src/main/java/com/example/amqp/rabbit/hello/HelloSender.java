package com.example.amqp.rabbit.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class HelloSender {

    @Resource
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "hello " + new Date();
        System.out.println("Sender: " +context);
        this.amqpTemplate.convertAndSend("hello", context);
    }

}
