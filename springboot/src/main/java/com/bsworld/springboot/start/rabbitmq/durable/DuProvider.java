package com.bsworld.springboot.start.rabbitmq.durable;
/*
*author: xieziyang
*date: 2018/8/27
*time: 16:40
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class DuProvider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqFactory.getConnection();
        Channel channel = connection.createChannel();
        //channel.exchangeDeclare(DuConstant.EXCHANGE, ExchangeType.DIRECT);
        AMQP.Queue.DeclareOk declareOk = channel.queueDeclare(DuConstant.DUQUEUE, false, false, false, null);
        String message = "this is from empty queue";
        String queue = declareOk.getQueue();
        System.out.println(queue);
        channel.basicPublish(DuConstant.EXCHANGE, queue,null,message.getBytes());
        AMQP.BasicProperties prop = new AMQP.BasicProperties();
    }
}
