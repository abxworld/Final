package com.bsworld.springboot.start.proxy.jdkNew;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-17 15:29
 * description:
 */
public class UserServiceProxy extends Proxy implements UserService {

    public UserServiceProxy(InvocationHandler h) {
        super(h);
    }

    @Override
    public void add(String something) {

    }

    @Override
    public void update(Long uid) {

    }
}
