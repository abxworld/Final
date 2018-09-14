package com.bsworld.springboot.start.blockingQueue;
/*
*author: xieziyang
*date: 2018/9/12
*time: 10:42
*description:
*/

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayQueue {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(16, true);
        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        queue.offer("test queue");
    }
}
