package com.example.amqp.rabbit.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "neo")
public class Receiver2 {

    @RabbitHandler
    public void process(String neo){
        System.out.println("Receiver2 : " + neo);
    }
}
