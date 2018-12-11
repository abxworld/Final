package com.bsworld.springboot.start.LocalDate;
/**
*author: xieziyang
*date: 2018/7/12
*time: 9:52
*description:
*/

import java.time.LocalDate;

public class Practice {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate localDate = LocalDate.now().plusDays(10);
        int i = localDate.compareTo(now);
        System.out.println(i);
        System.out.println("增加一行");
        System.out.println("再增加一行");
        System.out.println("需要切换分支");
        System.out.println("last再加一行");
    }
}
