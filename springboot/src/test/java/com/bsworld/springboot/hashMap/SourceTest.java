package com.bsworld.springboot.hashMap;
/*
*author: xieziyang
*date: 2018/9/6
*time: 13:13
*description:
*/

import java.math.BigDecimal;

public class SourceTest {
    public static void main(String[] args) {
        BigDecimal b0 = new BigDecimal("0.1");
        BigDecimal bigDecimal = b0.multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_DOWN);
        System.out.println(bigDecimal);
    }


}
