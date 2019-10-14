package com.bsworld.springboot.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-06-28 18:17
 * description:
 */
public class FlatMapTest {
    @Test
    public void run0() {
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<List<Integer>> totalList = new ArrayList<>();
        list0.add(1);
        list1.add(10);
        list0.add(2);
        list1.add(20);
        list0.add(3);
        list1.add(30);
        totalList.add(list0);
        totalList.add(list1);
        List<Integer> collect = totalList.stream().flatMap(a -> {
            a.add(10);
            return a.stream();
        }).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void run1() {
        List<Integer> list0 = new ArrayList<>();
        list0.add(10);
        list0.add(null);
        list0.add(100);
        list0.forEach(info ->{
            if (info == null) {
                return;
            }
            System.out.println(info);
        });

    }
}

