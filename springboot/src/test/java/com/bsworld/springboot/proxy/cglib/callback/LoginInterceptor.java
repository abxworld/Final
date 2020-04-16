package com.bsworld.springboot.proxy.cglib.callback;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-16 19:43
 * description:
 */
public class LoginInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib invoke start");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib invoke end");
        return result;
    }
}
