package com.bsworld.springboot.start.proxy.cglib;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-16 19:45
 * description:
 */
public class UserService {

    private String a = "hello_world";

    public String select(String uid) {
        System.out.println("do select, uid:" + uid);
        return a;
    }

}
