package com.bsworld.springboot.collection;
/*
*author: xieziyang
*date: 2018/9/3
*time: 13:34
*description:
*/

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleTest {
    @Test
    public void run1() {
        List<String> list  = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        Collections.shuffle(list);
        System.out.println(JSON.toJSONString(list));
    }
}
