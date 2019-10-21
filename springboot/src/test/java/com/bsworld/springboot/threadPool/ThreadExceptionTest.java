package com.bsworld.springboot.threadPool;

import com.bsworld.springboot.basic.MyException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-10-09 11:49
 * description:
 */
public class ThreadExceptionTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(() -> {
            try {
                System.out.println("sleep start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("sleep end");
                int i = 1 / 0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                throw new MyException();
            }
            return 10;
        });
        try {
            future.get();
        } catch (InterruptedException e) {
            System.out.println("get InterruptedException");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("get ExecutionException");
            e.printStackTrace();
        }


    }
}
