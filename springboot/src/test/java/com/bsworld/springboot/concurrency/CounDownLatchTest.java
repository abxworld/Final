package com.bsworld.springboot.concurrency;

import org.apache.poi.ss.formula.functions.T;

import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-06-12 19:16
 * description:
 */
public class CounDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(10);


        ExecutorService countService = Executors.newFixedThreadPool(10, r -> {
            Thread thread = new Thread(r);
//            thread.setDaemon(true);
            return thread;
        });
        ExecutorService waitService = Executors.newFixedThreadPool(10, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
//                thread.setDaemon(true);
                return thread;
            }
        });
        for (int i = 0; i < 10; i++) {
            countService.execute(() ->{
                System.out.println("start procees, threadName:" + Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                    cdl.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end procees, threadName:" + Thread.currentThread().getName());
            });
        }

        for (int i = 0; i < 5; i++) {
            waitService.execute(() ->{
                System.out.println("start wait, threadName:" + Thread.currentThread().getName());
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end wait, threadName:" + Thread.currentThread().getName());
            });
        }
        System.out.println("all end");

    }
}
