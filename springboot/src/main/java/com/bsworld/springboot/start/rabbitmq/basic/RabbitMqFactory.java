package com.bsworld.springboot.start.rabbitmq.basic;
/*
*author: xieziyang
*date: 2018/8/22
*time: 11:49
*description:
*/

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.concurrent.ConcurrentLinkedQueue;

public class RabbitMqFactory {
    private static ConcurrentLinkedQueue<Connection> queue = new ConcurrentLinkedQueue();

    static {
        Connection connection = null;
        try {
            ConnectionFactory factory = new ConnectionFactory();
            //设置RabbitMQ相关信息
            factory.setHost("47.95.117.211");
            factory.setUsername("guest");
            factory.setPassword("guest");
            factory.setPort(5672);
            connection = factory.newConnection();
            queue.add(connection);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return queue.poll();
    }
}
