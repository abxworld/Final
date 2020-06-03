package com.bsworld.springboot.concurrency.thread.stack;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-05-03 16:34
 * description:
 */
public class LocalAssignTest {
    private volatile Object arr2 = new Object();

    public static void main(String[] args) throws IOException, InterruptedException {
        LocalAssignTest t = new LocalAssignTest();
        long counts = 100000000;
        for (int i = 0; i < 10; i++) {
            System.out.println("circle start---" + i);
            CountDownLatch circleCdl = new CountDownLatch(3);
            t.invoke(t,counts, circleCdl);
            circleCdl.await();
            System.out.println("circle end---" + i);
        }
        System.in.read();
    }


    private void invoke(LocalAssignTest t, long counts, CountDownLatch circleCdl) {
        CountDownLatch cdl = new CountDownLatch(3);
        t.noneAssign(cdl, counts, circleCdl);
        t.memberAssign(cdl,counts,  circleCdl);
        t.localAssign(cdl, counts, circleCdl);
    }
    private void invokeTravel(LocalAssignTest t, long counts, CountDownLatch circleCdl) {
        CountDownLatch cdl = new CountDownLatch(3);
        t.localAssign(cdl, counts, circleCdl);
        t.memberAssign(cdl,counts, circleCdl);
        t.noneAssign(cdl, counts, circleCdl);
    }
    private void localAssign(CountDownLatch cdl,long counts, CountDownLatch circleCdl) {
        final Object b = this.arr2;
        new Thread(() -> {
            cdl.countDown();
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long start = System.currentTimeMillis();
            for (long i = 0; i < counts; i++) {
                Object a = b;
                a.toString();
            }
            long end = System.currentTimeMillis();
            circleCdl.countDown();
            System.out.println("局部变量赋值,耗时:" + (end - start));
        }).start();

    }

    private void memberAssign(CountDownLatch cdl, long counts, CountDownLatch circleCdl) {
        new Thread(() -> {
            cdl.countDown();
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long start = System.currentTimeMillis();
            for (long i = 0; i < counts; i++) {
                Object a = this.arr2;
                a.toString();
            }
            long end = System.currentTimeMillis();
            circleCdl.countDown();
            System.out.println("成员变量赋值,耗时:" + (end - start));
        }).start();
    }

    private void noneAssign(CountDownLatch cdl, long counts, CountDownLatch circleCdl) {
        new Thread(() -> {
            cdl.countDown();
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long start = System.currentTimeMillis();
            for (long i = 0; i < counts; i++) {

            }
            long end = System.currentTimeMillis();
            circleCdl.countDown();
            System.out.println("空轮询,耗时:" + (end - start));
        }).start();
    }


    private static class Testc {

    }
}
