package com.example.amqp.rabbit.object;

import com.example.amqp.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ObjectSender {

    @Resource
    private AmqpTemplate amqpTemplate;

    public void send(User user){
        System.out.println("Sender object: " + user.toString());
        this.amqpTemplate.convertAndSend("object",user);
    }
}
