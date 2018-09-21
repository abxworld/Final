package com.bsworld.nio.queue;
/*
*author: xieziyang
*date: 2018/4/25
*time: 23:35
*description:
*/

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueA {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue();
        String take = synchronousQueue.take();
        synchronousQueue.put("a");
        System.out.println(take);
        synchronousQueue.put("b");
    }
}
