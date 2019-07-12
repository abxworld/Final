package com.bsworld.springboot.concurrency;

import com.google.common.util.concurrent.RateLimiter;
import net.sf.ehcache.util.NamedThreadFactory;
import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-05-04 09:52
 * description:
 */
public class RateLimitTest {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.create(1);
        double waitTime = rateLimiter.acquire(8);
        System.out.println(waitTime);
        double secondWaitTime = rateLimiter.acquire(20);
        System.out.println(secondWaitTime);
        double thirdWaitTime = rateLimiter.acquire(30);
        System.out.println(thirdWaitTime);
    }
}
