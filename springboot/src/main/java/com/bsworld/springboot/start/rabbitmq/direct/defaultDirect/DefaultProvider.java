package com.bsworld.springboot.start.rabbitmq.direct.defaultDirect;
/*
*author: xieziyang
*date: 2018/8/27
*time: 15:39
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.ExchangeType;
import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class DefaultProvider {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqFactory.getConnection();
        /*Channel channel = connection.createChannel();
        channel.queueDeclare(DefaultConstant.DEFAULT_QUEUE, false, false, false, null);
        channel.queueBind(DefaultConstant.DEFAULT_QUEUE, "", DefaultConstant.DEFAULT_QUEUE);
        String message = "this is from default exchange";
        channel.basicPublish("", DefaultConstant.DEFAULT_QUEUE, null, message.getBytes());*/
        String messageTest = "this is from default exchange test";
        Channel channel1 = connection.createChannel();
        channel1.queueDeclare(DefaultConstant.DEFAULT_QUEUE, false, false, false, null);
        channel1.exchangeDeclare(DefaultConstant.DEFAULT_TEST_EXCHANGE, ExchangeType.DIRECT);
        channel1.queueBind(DefaultConstant.DEFAULT_QUEUE, DefaultConstant.DEFAULT_TEST_EXCHANGE,DefaultConstant.DEFAULT_TEST_ROUTINGKEY);
        for (int i = 0; i < 10; i++) {
            channel1.basicPublish(DefaultConstant.DEFAULT_TEST_EXCHANGE,DefaultConstant.DEFAULT_TEST_ROUTINGKEY,null,messageTest.getBytes());
        }
        AMQP.BasicProperties pro = new AMQP.BasicProperties();
        Integer deliveryMode = pro.getDeliveryMode();
        System.out.println(deliveryMode);

    }
}
