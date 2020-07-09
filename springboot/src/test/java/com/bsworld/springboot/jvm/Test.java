package com.bsworld.springboot.jvm;

import java.util.concurrent.TimeUnit;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-07-03 14:34
 * description:
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        Thread thread = new Thread(() -> {
            test.doSomeThing();
        });
//        thread.setDaemon(true);
        thread.start();
        System.out.println("hello");
    }

    public  void doSomeThing() {
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
