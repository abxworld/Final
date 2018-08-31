package com.bsworld.springboot.start.rabbitmq.fanout;
import com.bsworld.springboot.start.rabbitmq.basic.ExchangeType;
import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/*
*author: xieziyang
*date: 2018/8/27
*time: 13:46
*description:
*/

public class FanProvider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqFactory.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(ConstantFanout.QUEUE0, false, false, false, null);
        channel.queueDeclare(ConstantFanout.QUEUE1, false, false, false, null);
        channel.queueDeclare(ConstantFanout.QUEUE2, false, false, false, null);
        channel.queueDeclare(ConstantFanout.QUEUE3, false, false, false, null);
        channel.exchangeDeclare(ConstantFanout.FANOUT, ExchangeType.FOUNT);
        channel.queueBind(ConstantFanout.QUEUE0, ConstantFanout.FANOUT, "");
        channel.queueBind(ConstantFanout.QUEUE1, ConstantFanout.FANOUT, ConstantFanout.ROUTINGKEY1);
        channel.queueBind(ConstantFanout.QUEUE2, ConstantFanout.FANOUT, ConstantFanout.ROUTINGKEY2);
        channel.queueBind(ConstantFanout.QUEUE3, ConstantFanout.FANOUT, ConstantFanout.ROUTINGKEY3);
        String message = "this is from fanout exchange";
        channel.basicPublish(ConstantFanout.FANOUT, ConstantFanout.ROUTINGKEY0, null, message.getBytes("utf-8"));
    }
}
