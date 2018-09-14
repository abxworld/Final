package com.bsworld.springboot.TimeUnit;
/*
*author: xieziyang
*date: 2018/9/10
*time: 13:44
*description:
*/

import com.bsworld.springboot.basic.MyBean;
import org.junit.Test;
import org.springframework.util.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TimeUnitTest {
    @Test
    public void daysToHours() {
        //TimeUnit的主要作用是在执行需要接收时间的方法时给以一种方便，比如说传入下面的方法
        long hours = daysToHours(1l, TimeUnit.DAYS);//24
    }


    @Test
    public void  sleep() {
        try {
            Thread.sleep(5000);//通用写法
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            TimeUnit.SECONDS.sleep(5);//TimeUnit写法
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public long daysToHours(long time, TimeUnit unit) {
        return unit.toHours(time);
    }

    @Test
    public void run3() {
        List<MyBean> list = new ArrayList();
        list.stream().forEach(m -> System.out.println(m));
        list.stream().map(m -> m.getAge()).collect(Collectors.toList());
    }

    @Test
    public void run4() {
        String a = "0.12";
        boolean b = Double.valueOf(a) > 0;
    }

}
