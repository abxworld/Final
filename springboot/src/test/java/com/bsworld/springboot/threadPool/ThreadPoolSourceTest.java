package com.bsworld.springboot.threadPool;

import com.bsworld.springboot.start.circle.A;
import com.google.common.util.concurrent.Futures;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-01-10 14:37
 * description:
 */
public class ThreadPoolSourceTest {
    /**
     *
     * 测试线程池在submit任务之后如果执行任务过程中，任务里的代码抛出了异常的影响
     *
     * 1、抛出异常的所在线程会被释放，根据线程池的规则再按需添加线程
     *
     * 2、由于submit()方法最终是由{@link FutureTask#run()}方法里进行调用的，并且在run()方法里会执行try...catch..异常，
     *    并将异常赋值给一个结果参数，并且异常将不再抛出，这个时候即使任务执行过程中抛出异常，也不会再抛出
     *
     * 3、当执行{@link FutureTask#get()}，这个时候会判断结果参数，如果是异常那么就会抛出，所以在执行get()方法的时候一般需要try...catch...
     *
     * 结论:
     * submit()任务里抛出异常，如果不执行{@link FutureTask#get()}则不会抛出异常，否则会抛出异常，这个需要对异常进行处理
     *
     * */
    @Test
    public void testThreadPoolException() throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 10, TimeUnit.HOURS, new ArrayBlockingQueue<>(10));
        ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(executor);
        final   AtomicInteger ai = new AtomicInteger(0);
        while (true) {
            executorCompletionService.submit(() -> {
                try {
                    while (true) {
                            System.out.println("run start count:" + ai.get());
                            try {
                                try {
                                    System.out.println("process start");
                                    for (int i = 0; i < 100; i++) {
                                        int a = 1 / (50 - i);
                                    }
                                } catch (Throwable x) {
                                    System.out.println("process Throwable");
                                    throw new Error(x);
                                } finally {
                                    System.out.println("process first end");
                                }
//            } catch (Throwable t) {
//                System.out.println("catch all");
                            } finally {
                                System.out.println("process final end");
                            }
                    }
                }finally {
                    System.out.println("run end count:" + ai.get());
                    ai.getAndIncrement();
                    System.out.println("-------------------------------------");
                }
            });
            TimeUnit.SECONDS.sleep(1);
            try {
                Future take = executorCompletionService.take();
                take.get();
            } catch (Throwable t) {
                System.out.println("future get exception");
            }

        }
    }
}
