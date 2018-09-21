package com.bsworld.nio.javassit;
/*
*author: xieziyang
*date: 2018/5/2
*time: 16:15
*description:
*/

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
    //　这个就是我们要代理的真实对象
    private Object subject;

    //    构造方法，给我们要代理的真实对象赋初值
    public DynamicProxy(Object subject)
    {
        this.subject = subject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method: " + method);
        System.out.println("invoke subject:  " + method.invoke(subject,args));
        return null;
    }
}
