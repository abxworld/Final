package com.bsworld.springboot.threadPool;
/*
*author: xieziyang
*date: 2018/8/30
*time: 17:16
*description:
*/

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class PoolShutTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(5);
        RunClass0 run0 = new RunClass0();
        RunClass1 run1 = new RunClass1();
        scheduledService.submit(run0);
        scheduledService.submit(run1);
        scheduledService.shutdown();
        boolean terminated = scheduledService.isTerminated();
        System.out.println("terminated: " + terminated);
        if (!terminated) {
            System.out.println("执行立即关闭-start");
            List<Runnable> runnables = scheduledService.shutdownNow();
            runnables.forEach(m -> JSON.toJSONString(m));
            System.out.println("执行立即关闭-end");
        }
    }

    private static class RunClass0 implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("run0 start");
                Thread.sleep(5000);
                System.out.println("run0 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class RunClass1 implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("run1 start");
                Thread.sleep(10000);
                System.out.println("run1 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
