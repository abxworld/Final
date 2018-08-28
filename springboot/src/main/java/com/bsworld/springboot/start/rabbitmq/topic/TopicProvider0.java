package com.bsworld.springboot.start.rabbitmq.topic;
/*
*author: xieziyang
*date: 2018/8/27
*time: 14:44
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.ExchangeType;
import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class TopicProvider0 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqFactory.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(TopicConstant.QUEUE0, false, false, false, null);
        channel.exchangeDeclare(TopicConstant.TOPIC, ExchangeType.TOPIC);
        channel.queueBind(TopicConstant.QUEUE0, TopicConstant.TOPIC, TopicConstant.BINDINGKEY0);
        String message = "this is from topic";
        channel.basicPublish(TopicConstant.TOPIC, TopicConstant.ROUTINGKEY0, null, message.getBytes());
    }
}
