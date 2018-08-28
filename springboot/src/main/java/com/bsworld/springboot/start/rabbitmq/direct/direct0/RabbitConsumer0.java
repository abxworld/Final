package com.bsworld.springboot.start.rabbitmq.direct.direct0;
/*
*author: xieziyang
*date: 2018/8/22
*time: 12:53
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitConsumer0 {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = RabbitMqFactory.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(Constant.QUEUE_NAME, false, false, false, null);
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(Constant.QUEUE_NAME, true, consumer);
        channel.basicQos(1);
        while (true) {
            long startTime = System.currentTimeMillis();
            Thread.sleep(1000);
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("[consumer0] Received: " + message);
            long endTime = System.currentTimeMillis();
            System.out.println((endTime - startTime)/1000);
            //channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
