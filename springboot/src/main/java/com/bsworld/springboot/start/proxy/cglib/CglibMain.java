package com.bsworld.springboot.start.proxy.cglib;

import com.bsworld.springboot.start.proxy.cglib.callback.LoginInterceptor;
import com.bsworld.springboot.start.proxy.cglib.callback.LoginInterceptor2;
import com.bsworld.springboot.start.proxy.cglib.filter.LoginFilter;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.CallbackFilter;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-16 19:42
 * description:
 */
public class CglibMain {

    public static void main(String[] args) {
        createProxy();
    }
    /**
     *
     * 1、当指定多个{@link MethodInterceptor}时，
     *
     * 必须要在{@link Enhancer#setCallbackFilter(CallbackFilter)}设置相应的filter
     *
     * 否则将会报出异常,filter返回的数值就是{@link Enhancer#setCallbacks(Callback[])}数组的下标
     *
     * 也就是说filter返回不通的下标则会执行不通的callback，但是只会执行一个
     *
     *
     *
     *
     * */
    public static void createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallbacks(new Callback[]{new LoginInterceptor(), new LoginInterceptor2(), NoOp.INSTANCE});
        enhancer.setCallbackFilter(new LoginFilter());
        UserService userService = (UserService) enhancer.create();
        String select = userService.select("10000");
        System.out.println(select);
    }
}
