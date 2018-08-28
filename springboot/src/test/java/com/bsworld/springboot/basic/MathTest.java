package com.bsworld.springboot.basic;
/*
*author: xieziyang
*date: 2018/7/16
*time: 12:54
*description:
*/

import com.google.common.base.CharMatcher;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class MathTest {
    @Test
    public void run1() {
        int a = 400;
        double pow = Math.pow(a, 1.0 / 400);
        System.out.println(pow);
    }

    @Test
    public void run2() {
        String a = "a1da04'5s./1d23s";
        String s = CharMatcher.digit().retainFrom(a);
        System.out.println(s);
    }
    @Test
    public void run3() {
        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
        System.out.println(hashMap.putIfAbsent("hello", "A"));
        System.out.println(hashMap.putIfAbsent("hello", "V"));
    }

    @Test
    public void run4() {
        Date date = new Date(1531884710);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);
        System.out.println(format);
    }
}
