package com.example.amqp.rabbit.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Sender2 {
    @Resource
    private AmqpTemplate amqpTemplate;

    public void send(int i){
        String context = "Spring boot neo queue :" + i;
        System.out.println("Sender2: " + context);
        this.amqpTemplate.convertAndSend("neo",context);
    }
}
