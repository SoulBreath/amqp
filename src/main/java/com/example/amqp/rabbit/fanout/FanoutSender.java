package com.example.amqp.rabbit.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class FanoutSender {

    @Resource
    private AmqpTemplate amqpTemplate;
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send(){
        String context = "hi, fanout msg";
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("fanoutExchange", "",context);
    }
}
