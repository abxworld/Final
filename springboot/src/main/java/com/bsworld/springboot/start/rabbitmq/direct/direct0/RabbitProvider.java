package com.bsworld.springboot.start.rabbitmq.direct.direct0;
/*
*author: xieziyang
*date: 2018/8/22
*time: 11:51
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitProvider {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //创建连接工厂
        Connection connection = RabbitMqFactory.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(Constant.QUEUE_NAME, false, false, false, null);
        for (int i = 0; i < 10000; i++) {
            String message = "Hello World!---" + i;
            System.out.println("provider: " + message);
            channel.basicPublish("", Constant.QUEUE_NAME, null, message.getBytes());
            Thread.sleep(1000);
        }
        System.in.read();
    }

}
