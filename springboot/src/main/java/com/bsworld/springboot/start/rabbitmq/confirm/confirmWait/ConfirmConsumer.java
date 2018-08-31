package com.bsworld.springboot.start.rabbitmq.confirm.confirmWait;
/*
*author: xieziyang
*date: 2018/8/31
*time: 16:58
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.Connection;

public class ConfirmConsumer {
    public static void main(String[] args) {
        Connection connection = RabbitMqFactory.getConnection();
        Object object = connection;
    }
}
