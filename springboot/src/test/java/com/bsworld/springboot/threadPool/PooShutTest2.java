package com.bsworld.springboot.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2018-11-30 15:27
 * description:
 */
public class PooShutTest2 {
  private static   AtomicInteger a = new AtomicInteger(0);
  private static   AtomicInteger b = new AtomicInteger(0);
    public static void main(String[] args) {


            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.submit(() -> {
                try {
                    System.out.println();
                    Thread.sleep(100);
                    System.out.println("running: " + a.getAndIncrement());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
//            executorService = null;
    }

}
