package com.bsworld.springboot.date;

import java.util.Date;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2018-11-28 20:15
 * description:
 */
public class DateTest {
    public static void main(String[] args) {
        double freeMemory = (double)Runtime.getRuntime().freeMemory();
        System.out.println(freeMemory);
        double totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println(freeMemory / totalMemory);

    }
}
