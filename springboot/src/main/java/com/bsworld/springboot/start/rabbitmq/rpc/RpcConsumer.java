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

public class RpcConsumer {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqFactory.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(RpcConstant.RPCQUEUE, false, false, false, null);
        String message = "this message from consumer";
        AMQP.Queue.DeclareOk defaultQueue = channel.queueDeclare();
        AMQP.BasicProperties build = new AMQP.BasicProperties().builder().replyTo(defaultQueue.getQueue()).build();
        channel.basicPublish("", RpcConstant.RPCQUEUE, build, message.getBytes());
        channel.basicConsume(defaultQueue.getQueue(), new QueueingConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println(new String(body));
            }
        });
    }
}
