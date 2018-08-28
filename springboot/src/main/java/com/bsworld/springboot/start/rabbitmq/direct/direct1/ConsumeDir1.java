package com.bsworld.springboot.start.rabbitmq.direct.direct1;
/*
*author: xieziyang
*date: 2018/8/24
*time: 18:03
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.ExchangeType;
import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

public class ConsumeDir1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Connection connection = RabbitMqFactory.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(Constant1.DIRECT, ExchangeType.DIRECT);
        channel.queueDeclare(Constant1.QUEUE0, false, false, false, null);
        channel.queueDeclare(Constant1.QUEUE1, false, false, false, null);
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(Constant1.QUEUE0, consumer);
        channel.basicConsume(Constant1.QUEUE1, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            byte[] body = delivery.getBody();
            System.out.println(new String(body));
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
