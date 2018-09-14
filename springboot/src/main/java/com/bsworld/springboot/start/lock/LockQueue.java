package com.bsworld.springboot.start.lock;
/*
*author: xieziyang
*date: 2018/9/12
*time: 11:28
*description:
*/

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockQueue<E> {
    private static final int DEFAULT_CAP = 4;
    private transient Lock lock;
    private transient Condition notFull;
    private transient Condition notEmpty;
    private transient boolean fair;
    private E[] items;
    private int count;
    private int takeIndex;
    private int putIndex;

    public LockQueue() {
        this(DEFAULT_CAP, false);
    }

    public LockQueue(int cap, boolean fair) {
        this.lock = new ReentrantLock(fair);
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
        items = (E[]) new Object[cap];
    }

    public boolean offer(E e) {
        try {
            lock.lock();
            while (count == items.length) {
                notFull.await(3, TimeUnit.SECONDS);
                System.out.println("stop notFull.await()");
            }
            enqueue(e);
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            lock.unlock();
        }
        return true;
    }


    public E take() {
        E e = null;
        try {
            lock.lock();
            while (count == 0) {
                notEmpty.await();
            }
            e = dequeue();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            lock.unlock();
        }
        return e;
    }

    private boolean enqueue(E e) {
        items[putIndex] = e;
        putIndex++;
        if (putIndex == items.length) {
            putIndex = 0;
        }
        count++;
        notEmpty.signal();
        return true;
    }

    private E dequeue() {
        E e = items[takeIndex];
        items[takeIndex] = null;
        takeIndex++;
        if (takeIndex == items.length) {
            takeIndex = 0;
        }
        count--;
        notFull.signal();
        return e;
    }
}
