package com.bsworld.springboot.start.google.eventBus;


import com.google.common.eventbus.Subscribe;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-17 14:57
 * description:
 */
public class EventBusChangeRecorder {
    @Subscribe
    public void recordCustomerChange(String msg) {
        System.out.println("change receive, msg:" + msg);
    }

}
