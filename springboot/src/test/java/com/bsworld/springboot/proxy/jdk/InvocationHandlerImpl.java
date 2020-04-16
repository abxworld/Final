package com.bsworld.springboot.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-16 19:02
 * description:
 */
public class InvocationHandlerImpl implements InvocationHandler {

    Object target;

    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke start");
        Object result = method.invoke(target, args);
        System.out.println("invoke end");
        return result;
    }
}
