package com.bsworld.springboot.start.rabbitmq.direct.direct2;
/*
*author: xieziyang
*date: 2018/8/27
*time: 14:36
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

public class ConsumerDir2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Connection connection = RabbitMqFactory.getConnection();
        Channel channel = connection.createChannel();
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(Constant2.QUEUE0, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            byte[] body = delivery.getBody();
            System.out.println(new String(body));
        }
    }
}
