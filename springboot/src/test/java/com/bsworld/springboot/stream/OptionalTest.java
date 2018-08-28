package com.bsworld.springboot.stream;
/*
*author: xieziyang
*date: 2018/8/10
*time: 10:47
*description:
*/

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
    @Test
    public void run1() {
        List<Object> list = null;
       // Optional<List<Object>> list1 = Optional.ofNullable(list.stream().collect(Collectors.toList()));
        Optional.ofNullable(list);
    }

    @Test
    public void run2() {
        boolean assignableFrom = List.class.isAssignableFrom(ArrayList.class);
        System.out.println(assignableFrom);
    }
}
