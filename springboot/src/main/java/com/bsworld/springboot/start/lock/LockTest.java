package com.bsworld.springboot.start.lock;
/*
*author: xieziyang
*date: 2018/9/12
*time: 11:27
*description:
*/

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LockTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        LockQueue<String> queue = new LockQueue<>();
        Thread t0 = new Thread(new QueueRun0(queue));
        Thread t1 = new Thread(new QueueRun1(queue));
        t0.start();
        t1.start();
        System.in.read();
    }

    private static class QueueRun0 implements Runnable {
        LockQueue<String> queue;

        public QueueRun0(LockQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            queue.offer("a");
            queue.offer("b");
            queue.offer("c");
            queue.offer("d");
            System.out.println("LockQueue is enough");
            boolean flag = queue.offer("e");
            System.out.println("offer input success, flag: " + flag);
        }
    }

    private static class QueueRun1 implements Runnable {
        LockQueue<String> queue;

        public QueueRun1(LockQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                System.out.println("take sleep start");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("take sleep end");
                String take = queue.take();
                System.out.println("take element: " + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
