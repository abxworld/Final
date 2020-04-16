package com.bsworld.springboot.proxy.jdk;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-16 18:30
 * description:
 */
public class JdkProxyTest {

    @Test
    public void testCreate() {
//        JdkProxySource<JdkProxyService> proxySource = new JdkProxySource<>(JdkProxyTest.class.getClassLoader(),new Class[]{JdkProxyService.class});
//        JdkProxyService jdkProxyService = new JdkProxyServiceImpl();
//        UsageTracking<JdkProxyService> usageTracking = pooledObject -> {
//            System.out.println("invoke start");
//
//            System.out.println("invoke end");
//        };
//        JdkProxyService proxy = proxySource.createProxy(jdkProxyService, usageTracking);
//        proxy.add("nihao");
        DemoService demoService = new DemoServiceImpl();
        DemoService proxyService = (DemoService) Proxy.newProxyInstance(JdkProxyTest.class.getClassLoader(), new Class[]{DemoService.class}
                , new InvocationHandlerImpl(demoService));


        proxyService.add("hello world");
    }
}
