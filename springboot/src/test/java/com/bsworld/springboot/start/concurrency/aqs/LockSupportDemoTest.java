package com.bsworld.springboot.start.concurrency.aqs;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.Assert.*;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-20 14:47
 * description:
 *
 *
 */
public class LockSupportDemoTest {
    @Test
    public void run1() {
        System.out.println("start");
        Thread thread = Thread.currentThread();

        new Thread(() ->{
            try {
                TimeUnit.SECONDS.sleep(5);
                LockSupport.unpark(thread);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        LockSupport.park(new ReentrantLock());
        System.out.println("end");
    }
}