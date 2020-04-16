package com.bsworld.springboot.abstractTest;

import org.apache.commons.pool2.proxy.JdkProxySource;
import org.junit.Test;
import org.springframework.util.StopWatch;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-16 18:24
 * description:
 */
public class StopWatchTest {
    @Test
    public void run0() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start("task1");
        Thread.sleep(1000);
        stopWatch.stop();
        stopWatch.start("task2");
        Thread.sleep(500);
        stopWatch.stop();
        stopWatch.start("task3");
        Thread.sleep(700);
        stopWatch.stop();
        String prettyPrint = stopWatch.prettyPrint();
        System.out.println(prettyPrint);
    }
}
