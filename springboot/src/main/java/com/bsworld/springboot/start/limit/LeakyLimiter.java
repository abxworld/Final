package com.bsworld.springboot.start.limit;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-07-19 20:20
 * description:
 * 漏桶算法
 */
public class LeakyLimiter<T> {
    private ArrayBlockingQueue<T> queue;
    private boolean start;
    public LeakyLimiter<T> create(int size) {
        LeakyLimiter<T> limiter = new LeakyLimiter<>();
        queue = new ArrayBlockingQueue<>(size);
        limiter.queue = queue;
        limiter.start = true;

        return limiter;
    }

    private LeakyLimiter() {

    }

    public void acquire(T t) {
        try {
            queue.put(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void release() {
        while (start) {
            T element = queue.poll();

        }
    }
}
