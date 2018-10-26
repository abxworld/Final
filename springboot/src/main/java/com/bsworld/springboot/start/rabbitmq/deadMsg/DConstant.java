package com.bsworld.springboot.start.rabbitmq.deadMsg;
/*
*author: xieziyang
*date: 2018/10/17
*time: 19:28
*description:
*/

public interface DConstant {
    String exchangeType = "direct";
    String preExchange = "preExchange";
    String postExchange = "postExchange";
    String preQueue = "preQUeue";
    String postQueue = "postQUeue";
    String preRoutingKey = "pre.routing.key";
    String postRoutingKey = "post.routing.key";
}
