package com.bsworld.springboot.redis;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-05-15 10:26
 * description:
 */
public class RedisTest {
    public static void main(String[] args) {

        AtomicBoolean atomicBoolean = new AtomicBoolean();
        boolean b = atomicBoolean.compareAndSet(true, false);
        AtomicInteger atomicInteger = new AtomicInteger(10);
        int b1 = atomicInteger.incrementAndGet();
        System.out.println(b);
        System.out.println(b1);
    }
}
