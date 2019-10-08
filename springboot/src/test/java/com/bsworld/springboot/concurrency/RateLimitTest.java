package com.bsworld.springboot.concurrency;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-05-04 09:52
 * description:
 */
public class RateLimitTest {
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(500));
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(1);
        executor.execute(() -> {
            double result = rateLimiter.acquire(30);
            System.out.println("thread name:" + Thread.currentThread().getName() + "now time" + System.currentTimeMillis() + "result:" + result + " successCount:" + atomicInteger.getAndAdd(1));
        });
        for (int i = 0; i < 9; i++) {
            handle(rateLimiter, executor);
        }
    }

    @Test
    public void run2() {
        RateLimiter rateLimiter = RateLimiter.create(1);
        rateLimiter.acquire(120);
        rateLimiter.acquire(5);
    }


    public static void handle(RateLimiter rateLimiter, ThreadPoolExecutor executor) {
        executor.execute(() -> {
            double result = rateLimiter.acquire(1);
            System.out.println("thread name:" + Thread.currentThread().getName() + "now time" + System.currentTimeMillis() + "result:" + result + " successCount:" + atomicInteger.getAndAdd(1));
        });
    }
}
