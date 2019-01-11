package com.example.amqp.rabbit.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TopicSender {

    @Resource
    private AmqpTemplate amqpTemplate;

    public void send1(){
        String context = "hi, i am message";
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("exchange", "topic.message", context);
    }

    public void send2(){
        String context = "hi, i am messages";
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("exchange", "topic.messages", context);

    }

}
