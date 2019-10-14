package com.bsworld.springboot.start.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-06-25 11:28
 * description:
 */
@Component
public class HotDeployUtil implements ApplicationContextAware {
    private static ApplicationContext context;

    public static <T> T getSpringBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
    public static void main(String[] args) {
        String a =  "1000000";
        long b = 1000000l;
        boolean equals = a.equals(b);
        System.out.println(equals);
    }
}
