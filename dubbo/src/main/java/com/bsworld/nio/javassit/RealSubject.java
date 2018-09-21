package com.bsworld.nio.javassit;
/*
*author: xieziyang
*date: 2018/5/2
*time: 16:00
*description:
*/

public class RealSubject  implements Subject {
    String username;
    public RealSubject(String username) {
        this.username = username;
    }

    @Override
    public void rent() {
        System.out.println("rent start");
    }

    @Override
    public String hello(String str) {
        System.out.println("hello start");
        System.out.println("hello str:" + str);
        System.out.println("username:" + username);
        return str;
    }
}
