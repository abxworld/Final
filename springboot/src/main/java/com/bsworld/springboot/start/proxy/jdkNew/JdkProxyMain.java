package com.bsworld.springboot.start.proxy.jdkNew;

import java.lang.reflect.Proxy;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-17 15:28
 * description:
 */
public class JdkProxyMain {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserService proxyService = (UserService) Proxy.newProxyInstance(JdkProxyMain.class.getClassLoader()
                , new Class[]{UserService.class}
                , new InvocationHandlerImpl(userService));

        proxyService.add("hello world");
    }
}
