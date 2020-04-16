package com.bsworld.springboot.proxy.cglib.callback;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-16 20:00
 * description:
 */
public class LoginInterceptor2 implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("LoginInterceptor2 invoke start");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("LoginInterceptor2 invoke end");
        return result;
    }
}
