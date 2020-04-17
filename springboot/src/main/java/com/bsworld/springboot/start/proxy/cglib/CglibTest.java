package com.bsworld.springboot.start.proxy.cglib;

import com.bsworld.springboot.start.proxy.cglib.callback.LoginInterceptor;
import com.bsworld.springboot.start.proxy.cglib.callback.LoginInterceptor2;
import com.bsworld.springboot.start.proxy.cglib.filter.LoginFilter;
import org.junit.Test;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-16 19:42
 * description:
 */
public class CglibTest {
    @Test
    public void createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallbacks(new Callback[]{new LoginInterceptor(), new LoginInterceptor2(), NoOp.INSTANCE});
        enhancer.setCallbackFilter(new LoginFilter());
        UserService userService = (UserService)enhancer.create();
        userService.select("a10000");
    }
}
