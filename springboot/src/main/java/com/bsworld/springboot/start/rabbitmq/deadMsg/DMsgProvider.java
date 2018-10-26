package com.bsworld.springboot.start.rabbitmq.deadMsg;
/*
*author: xieziyang
*date: 2018/10/17
*time: 19:21
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.google.common.collect.Maps;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.HashMap;

public class DMsgProvider {
        public static void main(String[] args) throws IOException {
            Connection connection = RabbitMqFactory.getConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(DConstant.preExchange, DConstant.exchangeType);
            channel.exchangeDeclare(DConstant.postExchange, DConstant.exchangeType);
            HashMap<String, Object> hashMap = Maps.newHashMap();
            hashMap.put("x-dead-letter-exchange", DConstant.postExchange);
            hashMap.put("x-dead-letter-routing-key", DConstant.postRoutingKey);
            channel.queueDeclare(DConstant.preQueue,false,false,false,hashMap);
            channel.queueDeclare(DConstant.postQueue, false, false, false, null);
            channel.queueBind(DConstant.preQueue,DConstant.preExchange,DConstant.preRoutingKey);
            channel.queueBind(DConstant.postQueue, DConstant.postExchange, DConstant.postRoutingKey);
            String message = "this is to dead";
            AMQP.BasicProperties properties = new AMQP.BasicProperties();
            AMQP.BasicProperties build = properties.builder().expiration("15000").build();
            channel.basicPublish(DConstant.preExchange,DConstant.preRoutingKey, false,false,build, message.getBytes());
        }
}
