package com.example.amqp;

import com.example.amqp.entity.Order;
import com.example.amqp.rabbit.delay.DelaySender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DelayRabbitTests {

    @Resource
    private DelaySender delaySender;

    @Test
    public void sendDelay() throws InterruptedException {
        Order order1 = new Order();
        order1.setOrderStatus(0);
        order1.setOrderId("123456");
        order1.setOrderName("小米6");

        Order order2 = new Order();
        order2.setOrderStatus(0);
        order2.setOrderId("456789");
        order2.setOrderName("小米8");

        delaySender.sendDelay(order1);
        Thread.sleep(6 * 1000);
        delaySender.sendDelay(order2);
        Thread.sleep(6 * 1000);
    }
}
