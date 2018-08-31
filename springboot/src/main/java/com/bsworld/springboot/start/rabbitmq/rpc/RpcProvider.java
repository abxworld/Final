package com.bsworld.springboot.start.rabbitmq.rpc;
/*
*author: xieziyang
*date: 2018/8/31
*time: 18:56
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.*;

import java.io.IOException;

public class RpcProvider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqFactory.getConnection();
        Channel channel = connection.createChannel();
        channel.basicConsume(RpcConstant.RPCQUEUE, new QueueingConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println(new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false);
                String replyTo = properties.getReplyTo();
                String message = "this is from provider message";
                channel.basicPublish("", replyTo, null, message.getBytes());
            }
        });
    }
}
