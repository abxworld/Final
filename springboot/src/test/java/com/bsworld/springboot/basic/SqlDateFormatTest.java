package com.bsworld.springboot.basic;
/*
*author: xieziyang
*date: 2018/8/21
*time: 14:05
*description:
*/

import java.text.SimpleDateFormat;
import java.util.Date;

public class SqlDateFormatTest {
    public static void main(String[] args) {
        long time = new Date().getTime();
        long millis = System.currentTimeMillis();
        System.out.println(String.valueOf(time).length());
        System.out.println(String.valueOf(millis).length());
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}
