package com.bsworld.springboot.start.rabbitmq.confirm.confirmCallBack;
/*
*author: xieziyang
*date: 2018/8/31
*time: 16:58
*description:
*/

import com.bsworld.springboot.start.rabbitmq.basic.RabbitMqFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class ConfirmProvider {
    public static void main(String[] args) {
        Connection connection = RabbitMqFactory.getConnection();
        try {
            Channel channel = connection.createChannel();
            channel.confirmSelect();
            channel.queueDeclare(ConfirmConstant.QUEUENAME, false, false, false, null);

            channel.addConfirmListener(new ConfirmListener() {
                @Override
                public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                    System.out.println("handleAck: " + deliveryTag + "        multiple:" + multiple);
                }

                @Override
                public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                    System.out.println("handleNack: " + deliveryTag);
                    System.out.println("handleNack: " + multiple);
                }
            });
            for (int i = 0; i < 5; i++) {
                String message = "confirm mesage, name:" + i;
                channel.basicPublish("", ConfirmConstant.QUEUENAME, null, message.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void run1() {

    }
}
