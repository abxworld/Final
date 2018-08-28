package com.bsworld.springboot.threadPool;
/*
*author: xieziyang
*date: 2018/8/28
*time: 16:29
*description:
*/

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestPool {

   public static void main(String[] args) {
       TestPool testPool = new TestPool();
       String pool = testPool.pool();
       System.out.println(pool);
   }

   public String pool() {
       BlockingQueue queue = new ArrayBlockingQueue(16);
       ThreadPoolExecutor executor = new ThreadPoolExecutor(3,5, 10l, TimeUnit.SECONDS,queue);
       executor.execute(new RunObj());
       return "execute";
   }

   public static class RunObj implements Runnable{
       @Override
       public void run() {
           try {
               Thread.sleep(5000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("执行runnable");
       }
   }
}
