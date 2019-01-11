package com.example.amqp.rabbit.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.B")
public class ReceiverB {

    @RabbitHandler
    public void process(String message){
        System.out.println("fanout Receiver B : " + message);
    }
}
