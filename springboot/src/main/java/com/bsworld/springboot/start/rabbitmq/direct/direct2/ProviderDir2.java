package com.bsworld.springboot.start.rabbitmq.direct.direct2;
/*
*author: xieziyang
*date: 2018/8/24
*time: 16:47
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.ExchangeType;
import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class ProviderDir2 {
    private static final String routing0 = "abc";
    private static final String routing1 = "abx";

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqFactory.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(Constant2.DIRECT, ExchangeType.DIRECT);
        channel.queueDeclare(Constant2.QUEUE0,false,false,false,null);
        channel.queueBind(Constant2.QUEUE0, Constant2.DIRECT, routing0);
        channel.queueBind(Constant2.QUEUE0, Constant2.DIRECT, routing1);
        String message0 = "this is from ProviderDir1  20";
        String message1 = "this is from ProviderDir1  21";
        channel.basicPublish(Constant2.DIRECT, routing0, null, message0.getBytes());
        channel.basicPublish(Constant2.DIRECT, routing1, null, message1.getBytes());
    }
}
