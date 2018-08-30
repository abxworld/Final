package com.bsworld.springboot.start.threadPool;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.lang.management.ManagementFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
*author: xieziyang
*date: 2018/8/28
*time: 18:52
*description:
*/
@Component
public class ThreadShut {
    ScheduledExecutorService schService = null;

    @PostConstruct
    public void start() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        String pid = name.split("@")[0];
        System.out.println("pid::" + pid);
        schService = Executors.newScheduledThreadPool(3);
        schService.scheduleWithFixedDelay(new Rate(), 3, 3, TimeUnit.SECONDS);
    }

    @PreDestroy
    public void endDestroy() {
        System.out.println("start destroy");
        if (schService != null) {
            schService.shutdown();
            boolean shutdown = schService.isShutdown();
            if (!shutdown) {
                schService.shutdownNow();
            }
            System.out.println("end destroy, result: " + schService.isShutdown());
        } else {

        }
    }

    private class Rate implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("sleep start");
                Thread.sleep(5000);
                System.out.println("sleep end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
