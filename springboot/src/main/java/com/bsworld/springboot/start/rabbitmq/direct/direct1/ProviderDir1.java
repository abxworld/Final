package com.bsworld.springboot.start.rabbitmq.direct.direct1;
/*
*author: xieziyang
*date: 2018/8/24
*time: 16:47
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.ExchangeType;
import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ReturnListener;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ProviderDir1 {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMqFactory.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(Constant1.DIRECT, ExchangeType.DIRECT);
        //channel.queueDeclare(Constant1.QUEUE0, false, false, false, null);
       // channel.queueDeclare(Constant1.QUEUE1, false, false, false, null);
       // channel.queueBind(Constant1.QUEUE0, Constant1.DIRECT, Constant1.ROUTINGKEY);
        //channel.queueBind(Constant1.QUEUE0, Constant1.DIRECT, Constant1.ROUTINGKEY + "a");
        String message0 = "this is from ProviderDir1  00";
        //String message1 = "this is from ProviderDir1  11";
        channel.basicPublish(Constant1.DIRECT, "123153", true, false,null, message0.getBytes());
        // channel.basicPublish(Constant1.DIRECT, Constant1.ROUTINGKEY, null, message1.getBytes());
        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));
            }
        });
    }
}
