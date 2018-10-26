package com.bsworld.springboot.start.time;
/*
*author: xieziyang
*date: 2018/10/25
*time: 10:32
*description:
*/

import com.alibaba.fastjson.JSON;
import com.bsworld.springboot.start.aop.User;

import java.math.BigDecimal;
import java.util.HashMap;

public class TimeTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("hello");
        user.setAge((short)1);
        user.setScore(new BigDecimal(100.2249646446));
        HashMap hashMap = JSON.parseObject(JSON.toJSONString(user), HashMap.class);
        Object score = hashMap.get("score");
        if (score instanceof BigDecimal) {
            System.out.println("BigDecimal");
        } else if (score instanceof Integer) {
            System.out.println("Integer");
        } else if (score instanceof String) {
            System.out.println("String");
        }
        System.out.println("Tca56ada892341f5b2acdcf7c054e7f3".length());
        System.out.println("Xca56ada892341f5b2acdcf7c054e7f3".length());
        System.out.println("Xc00e4919a174ea1a417b4d20925b31b".length());
    }
}
