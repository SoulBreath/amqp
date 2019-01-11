package com.example.amqp;

import com.example.amqp.entity.User;
import com.example.amqp.rabbit.fanout.FanoutSender;
import com.example.amqp.rabbit.hello.HelloSender;
import com.example.amqp.rabbit.many.Sender1;
import com.example.amqp.rabbit.many.Sender2;
import com.example.amqp.rabbit.object.ObjectSender;
import com.example.amqp.rabbit.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    @Resource
    private HelloSender helloSender;
    @Resource
    private Sender1 sender1;
    @Resource
    private Sender2 sender2;
    @Resource
    private ObjectSender objectSender;
    @Resource
    private TopicSender topicSender;
    @Resource
    private FanoutSender fanoutSender;

    @Test
    public void hello() throws InterruptedException {
        helloSender.send();
        Thread.sleep(1000);
    }

    @Test
    public void oneToMany(){
        for (int i = 0; i<10; i++){
            sender1.send(i);
            sender2.send(i);
        }
    }

    @Test
    public void sendObject(){
        User user = new User();
        user.setName("张三");
        user.setPass("123456");
        objectSender.send(user);
    }

    @Test
    public void topic1() throws InterruptedException {
        topicSender.send1();
        Thread.sleep(1000);
    }

    @Test
    public void topic2() throws InterruptedException {
        topicSender.send2();
        Thread.sleep(1000);
    }

    @Test
    public void fanout(){
        fanoutSender.send();
    }
}
