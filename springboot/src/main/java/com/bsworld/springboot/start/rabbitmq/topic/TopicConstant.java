package com.bsworld.springboot.start.rabbitmq.topic;
/*
*author: xieziyang
*date: 2018/8/27
*time: 14:43
*description:
*/

public class TopicConstant {
    public static final String TOPIC = "topicExchange";
    public static final String QUEUE0 = "topicQueue00";
    public static final String BINDINGKEY0 = "*.binding.#";
    public static final String ROUTINGKEY0 = "abx.binding";
}
