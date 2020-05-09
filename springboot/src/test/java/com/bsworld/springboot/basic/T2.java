package com.bsworld.springboot.basic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-05-06 18:16
 * description:
 */
public class T2 {
    int a = 0;
    boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        SyncQueue<T2> writeAbq = new SyncQueue<T2>(reentrantLock);
        SyncQueue<T2> readAbq = new SyncQueue(reentrantLock);
        new Thread(() -> {
            while (true) {
                T2 t = writeAbq.take();
                t.writer();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                T2 t = readAbq.take();
                t.read();
            }
        }).start();
        int a = 0;
        while (true) {
            if (a == 0) {
                TimeUnit.SECONDS.sleep(1);
            }
            T2 t = new T2();
            writeAbq.put(t);
            readAbq.put(t);
            a++;
        }
    }

    public void writer() {
        a = 1;
        flag = true;
    }

    public void read() {
        if (flag) {
            int i = a + 1;
            if (i == 1) {
                System.out.println("true");
            }
        }
    }


    private static class SyncQueue<T> {
        private T t1;
        private T t2;
        private ReentrantLock lock;
        private Condition putCondition;
        private Condition takeCondition;

        public SyncQueue(ReentrantLock lock) {
            this.lock = lock;
            this.putCondition = lock.newCondition();
            this.takeCondition = lock.newCondition();
        }

        public void put(T t) {
            try {
                lock.lock();
                if (t1 == null && t2 == null) {
                    putCondition.await();
                }
                this.t1 = t;
                this.t2 = t;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                takeCondition.signalAll();
                lock.unlock();
            }
        }

        public T take() {
            T memberT = null;
            try {
                lock.lock();
                T t1 = this.t1;
                T t2 = this.t2;
                if (t1 == null && t2 == null) {
                    takeCondition.await();
                }
                memberT = t1 != null ? t1 : t2;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (t1 == null && t2 == null) {
                    putCondition.signalAll();
                }
                lock.unlock();
            }
            return memberT;
        }


    }
}
