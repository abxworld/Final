package com.bsworld.springboot.start.rabbitmq.deadMsg;
/*
*author: xieziyang
*date: 2018/10/17
*time: 19:35
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.*;

import java.io.IOException;

public class DMsgConsumer {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqFactory.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(DConstant.postQueue, false, false, false, null);
        final long start = System.currentTimeMillis();
        channel.basicConsume(DConstant.postQueue, new QueueingConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                long end = System.currentTimeMillis();
                long total = (end - start) / 1000;
                System.out.println(new String(body));
                System.out.println(total);
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
        System.out.println("hello");
    }
}
