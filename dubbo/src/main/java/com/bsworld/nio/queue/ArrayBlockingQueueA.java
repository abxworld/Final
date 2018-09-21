package com.bsworld.nio.queue;
/*
*author: xieziyang
*date: 2018/4/25
*time: 23:39
*description:
*/

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class ArrayBlockingQueueA {
    static CountDownLatch latch = new CountDownLatch(2);
    private static ArrayBlockingQueueA a = new ArrayBlockingQueueA();
    public static ArrayBlockingQueueA getA() {
        return a;
    }
    ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(16);
    public static void main(String[] args) {
         Object o = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "执行");
                    latch.countDown();
                    latch.await();
                    Thread.sleep(1000);
                    String take = ArrayBlockingQueueA.getA().queue.take();
                    System.out.println(take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "执行");
                    latch.countDown();
                    latch.await();
                    ArrayBlockingQueueA.getA().queue.put("hello");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


   /* public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueueA.getA().queue.put("hello");
        String take = ArrayBlockingQueueA.getA().queue.take();
        System.out.println(take);
    }*/
}
