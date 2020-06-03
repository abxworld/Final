package com.bsworld.springboot.concurrency.thread.stack;

import java.io.IOException;
import java.util.LinkedList;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-05-14 12:41
 * description:
 */
public class LocalAssignTest2 {
    private Long a = new Long(1000);
    public static void main(String[] args) throws IOException {
        LocalAssignTest2 test = new LocalAssignTest2();
        new LinkedList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    long newA = test.a;
                    long newB = newA;
                }
            }
        },"while-test")
        .start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    long c = test.a;
//                    System.in.read();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "one-test").start();
        System.in.read();
    }
}
