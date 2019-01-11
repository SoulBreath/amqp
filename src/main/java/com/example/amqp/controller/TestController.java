package com.example.amqp.controller;

import com.example.amqp.entity.Order;
import com.example.amqp.rabbit.delay.DelaySender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private DelaySender delaySender;

    @GetMapping("/sendDelay")
    public Object sendDelay(){
        Order order1 = new Order();
        order1.setOrderStatus(0);
        order1.setOrderId("123456");
        order1.setOrderName("小米6");

        Order order2 = new Order();
        order2.setOrderStatus(1);
        order2.setOrderId("456789");
        order2.setOrderName("小米8");

        Order order3 = new Order();
        order3.setOrderStatus(0);
        order3.setOrderId("666666");
        order3.setOrderName("荣耀9");

        delaySender.sendDelay(order1);
        delaySender.sendDelay(order2);
        delaySender.sendDelay(order3);
        return "ok";
    }
}
