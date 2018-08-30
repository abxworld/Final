package com.bsworld.springboot.threadPool;
/*
*author: xieziyang
*date: 2018/8/30
*time: 15:32
*description:
*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;

public class PooInterruptedTest {
     private static final Logger LOGGER = LoggerFactory.getLogger(PooInterruptedTest.class);
    public static void main(String[] args) {
        Thread thread = new Thread(new RunObj());
        thread.start();
        System.out.println("main start");
        try {
            Thread.sleep(3000);
            thread.interrupt();
            boolean interrupted = Thread.interrupted();
            System.out.println(interrupted);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread);
        System.out.println("main end");
    }

    private static class RunObj implements Runnable {
        @Override
        public void run() {
            ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(16);
           /* for (int i = 0; i <10 ; i++) {
                queue.add("a");
            }*/
            try {
                System.out.println("run start");
                queue.take();
                System.out.println("run end");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("interrupted:　" + Thread.currentThread().isInterrupted());
            }
        }
    }
}
