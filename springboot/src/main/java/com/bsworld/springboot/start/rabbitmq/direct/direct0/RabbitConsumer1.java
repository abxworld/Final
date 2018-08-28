package com.bsworld.springboot.start.rabbitmq.direct.direct0;
/*
*author: xieziyang
*date: 2018/8/22
*time: 18:25
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitConsumer1 {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = RabbitMqFactory.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(Constant.QUEUE_NAME, false, false, false, null);
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(Constant.QUEUE_NAME, true, consumer);
        channel.basicQos(1);
        while (true) {
            Thread.sleep(3000);
            long startTime = System.currentTimeMillis();
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("[consumer1] Received: " + message);
            long endTime = System.currentTimeMillis();
            System.out.println((endTime - startTime)/1000);
//            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
