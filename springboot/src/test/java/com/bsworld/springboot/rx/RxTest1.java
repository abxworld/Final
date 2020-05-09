package com.bsworld.springboot.rx;

import com.google.common.collect.Lists;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.junit.Test;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-05-08 17:34
 * description:
 */
public class RxTest1 {
    @Test
    public void run1() {
        Flowable.just("Hello World").subscribe(System.out::println);

        Lists.newArrayList("hello").stream();


    }

    @Test
    public void run2() throws InterruptedException {
        Flowable.fromCallable(() -> {
            Thread.sleep(1000); //  imitate expensive computation
            return "Done";
        })
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.single())
                .subscribe(System.out::println, Throwable::printStackTrace);

        Thread.sleep(2000); // <--- wait for the flow to finish
    }


    @Test
    public void run3() throws InterruptedException {
        Flowable.range(1, 10)
                .observeOn(Schedulers.computation())
                .map(v -> v * v)
                .blockingSubscribe(System.out::println);
    }

    @Test
    public void run4() throws InterruptedException {
        Flowable.range(1, 10)
                .flatMap(v ->
                        Flowable.just(v)
                                .subscribeOn(Schedulers.computation())
                                .map(w -> w * w)
                )
                .blockingSubscribe(System.out::println);
    }
    @Test
    public void run5(){
        @NonNull Flowable<String> hello = Flowable.just("hello");

        hello.flatMap(m -> Flowable.just(m + "1"))
                .flatMap(m -> Flowable.just(m + "2"))
            .subscribe(System.out::println)
        ;
    }

    @Test
    public void run6(){
        @NonNull Flowable<String> hello = Flowable.just("hello");
        hello.flatMap(m -> Flowable.just(m + "1").flatMap(n -> Flowable.just(m + n))).subscribe(System.out::println);
    }
}
