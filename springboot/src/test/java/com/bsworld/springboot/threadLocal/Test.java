package com.bsworld.springboot.threadLocal;
/*
*author: xieziyang
*date: 2018/8/24
*time: 15:31
*description:
*/

import com.bsworld.springboot.basic.MyBean;

public class Test {
    private static final ThreadLocal<MyBean> LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<MyBean> REMOTE = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        MyBean myBean = new MyBean();
        LOCAL.set(myBean);
        REMOTE.set(LOCAL.get());
        Thread.sleep(3000);
        LOCAL.remove();
        MyBean myBean1 = REMOTE.get();
        System.out.println(myBean1);
    }
}
