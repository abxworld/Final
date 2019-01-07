package com.bsworld.springboot.date;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2018-11-28 20:15
 * description:
 */
public class DateTest {
    public static void main(String[] args) {
     /*   double freeMemory = (double)Runtime.getRuntime().freeMemory();
        System.out.println(freeMemory);
        double totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println(freeMemory / totalMemory);*/

        DateTime dt = new DateTime();
        DateTime dt1 = dt.plusMillis(10000);
        DateTime dt2 = dt.plusMonths(1);
        System.out.println(dt1.toDate().getTime());
        System.out.println(dt2.toDate().getTime());
    }
}
