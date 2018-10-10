package com.bsworld.springboot.start.jvm;
/*
*author: xieziyang
*date: 2018/9/26
*time: 10:43
*description:
*/

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MyHeap {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal(0.0000000000000000);
        boolean b1 = b.doubleValue() == 0;
        System.out.println(b1);
        System.out.println(b.doubleValue());

//        List cal = cal();
//        System.out.println(cal);
    }

    private static List cal() {
        while (true) {
            List list = new ArrayList();
             
        }
    }
}
