package com.bsworld.springboot.stream;
/*
*author: xieziyang
*date: 2018/9/21
*time: 10:55
*description:
*/

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapTest {
    @Test
    public void run1() {
        String[] a = new String[]{"a", "b"};
        List<Short> collect = Arrays.stream(a).distinct().map(m -> Short.valueOf(m)).collect(Collectors.toList());
    }

    @Test
    public void run2() {
        String a = "23151515333333333";
        System.out.println(a.length());
    }
}
