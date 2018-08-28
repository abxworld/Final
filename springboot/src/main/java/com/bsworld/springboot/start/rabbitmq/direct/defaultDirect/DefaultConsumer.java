package com.bsworld.springboot.start.rabbitmq.direct.defaultDirect;
/*
*author: xieziyang
*date: 2018/8/27
*time: 15:41
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.*;

import java.io.IOException;

public class DefaultConsumer {
    public static void main(String[] args) throws IOException, InterruptedException {
        String consume = consume();
        System.out.println(consume);
    }

    public static String consume() throws IOException {
        Connection connection = RabbitMqFactory.getConnection();
        Channel channel = connection.createChannel();
        channel.basicConsume(DefaultConstant.DEFAULT_QUEUE, new QueueingConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println(new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
        return "invoke end";
    }
}
