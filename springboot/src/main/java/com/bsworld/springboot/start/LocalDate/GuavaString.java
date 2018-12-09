package com.bsworld.springboot.start.LocalDate;
/*
*author: xieziyang
*date: 2018/7/13
*time: 13:02
*description:
*/

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class GuavaString {
    public static void main(String[] args) {
        Object hello = Optional.ofNullable(null).orElse("have none");
        System.out.println(hello);
        List<String> list = Arrays.asList("hello", "world");
        System.out.println("第一行");
    }
}
