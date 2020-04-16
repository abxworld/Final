package com.bsworld.springboot.proxy.cglib.filter;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-16 20:03
 * description:
 */
public class LoginFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        String methodName = method.getName();

        if ("select".equals(methodName)) {
            return 0;
        }

        return 1;
    }
}
