package com.bsworld.springboot.string;
/*
*author: xieziyang
*date: 2018/9/20
*time: 14:57
*description:
*/

import org.junit.Test;

public class SubStringTest {
    @Test
    public void run1() {
        String a = "123456789";
        int indexOf = a.lastIndexOf('7');
        String substring = a.substring(indexOf + 1);
        System.out.println(substring);
    }
}
