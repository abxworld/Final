package com.bsworld.springboot.start.rabbitmq.fanout;
/*
*author: xieziyang
*date: 2018/8/27
*time: 13:53
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

public class FanConsumer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Connection connection = RabbitMqFactory.getConnection();
        Channel channel = connection.createChannel();
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(ConstantFanout.QUEUE1, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            byte[] body = delivery.getBody();
            System.out.println(new String(body));
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
