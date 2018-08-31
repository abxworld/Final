package com.bsworld.springboot.start.rabbitmq.confirm.confirmCallBack;
/*
*author: xieziyang
*date: 2018/8/31
*time: 16:58
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.*;

import java.io.IOException;

public class ConfirmConsumer {
    public static void main(String[] args) {
        Connection connection = RabbitMqFactory.getConnection();
        try {
            Channel channel = connection.createChannel();
            channel.basicConsume(ConfirmConstant.QUEUENAME,new QueueingConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    super.handleDelivery(consumerTag, envelope, properties, body);
                    System.out.println(new String(body));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
