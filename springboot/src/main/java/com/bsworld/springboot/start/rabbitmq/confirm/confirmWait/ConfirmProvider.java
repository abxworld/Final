package com.bsworld.springboot.start.rabbitmq.confirm.confirmWait;
/*
*author: xieziyang
*date: 2018/8/31
*time: 16:58
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class ConfirmProvider {
    public static void main(String[] args) {
        Connection connection = RabbitMqFactory.getConnection();
        try {
            Channel channel = connection.createChannel();
            channel.confirmSelect();
            channel.queueDeclare(ConfirmConstant.QUEUENAME, false, false, false, null);
            long sum = 0L;
            //    final long start = System.currentTimeMillis();
            for (int i = 0; i < 5; i++) {
                String message = "this is from confirm, count" + i;
                channel.basicPublish("", ConfirmConstant.QUEUENAME, null, message.getBytes());
                long sumStart = System.currentTimeMillis();
                channel.waitForConfirms();
                sum = sum + (System.currentTimeMillis() - sumStart);
            }
            channel.waitForConfirmsOrDie();
            // System.out.println("执行waitForConfirmsOrDie耗费时间: " + (System.currentTimeMillis() - start) + "ms");
            System.out.println("执行waitForConfirmsOrDie耗费时间: " + sum + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
