package com.bsworld.springboot.threadPool;
/*
*author: xieziyang
*date: 2018/8/30
*time: 15:32
*description:
*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

public class PooInterruptedTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(PooInterruptedTest.class);
    static Object obj = new Object();

    public static void main(String[] args) throws IOException {
        Thread thread = new Thread(new RunObj());
        synchronized (obj) {
            thread.start();
            System.out.println("main start");
            System.out.println("main end");
            thread.interrupt();
            //thread.join();
        }
    }

    private static class RunObj implements Runnable {
        @Override
        public void run() {
            ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(16);
            System.out.println("run start");
            synchronized (obj) {
                System.out.println("thread, interrupted: " + Thread.currentThread().isInterrupted());
                System.out.println("run end");
            }
        }
    }
}
