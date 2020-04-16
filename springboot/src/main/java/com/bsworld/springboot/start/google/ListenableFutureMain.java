package com.bsworld.springboot.start.google;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import javax.annotation.Nullable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-03-23 00:30
 * description:
 */
public class ListenableFutureMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ListeningExecutorService service = MoreExecutors.listeningDecorator(executorService);
        ListenableFuture<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "hello";
            }
        });
        future.addListener(() ->{
            System.out.println("nihao");
        }, executorService);
    }
}
