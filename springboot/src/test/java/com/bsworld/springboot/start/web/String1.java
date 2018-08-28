package com.bsworld.springboot.start.web;
/*
*author: xieziyang
*date: 2018/7/23
*time: 10:46
*description:
*/

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class String1 {

    private int m;

    public static void main(String[] args) {
//        testJoin();
//        collectJoin();
//        testPatternPredicate();
    }

    public static void testJoin() {
        String join = String.join(":", "a", "b", "c");
        System.out.println(join);
    }

    public static void collectJoin() {
        String collect = Stream.of("a", "b", "c").collect(Collectors.joining(","));
        System.out.println(collect);
    }

    public static void testPatternPredicate() {
        List<String> collect = Stream.of("bob@gmail.com", "alice@hotmail.com").filter(Pattern.compile(".*@gmail\\.com").asPredicate()).collect(Collectors.toList());
        collect.stream().forEach(m -> System.out.println(m));
    }

    @Test
    public void testHashMap() {
        HashMap<Integer, String> hashMap = Maps.newHashMap();

        for (int i = 0; i < 10; i++) {
            hashMap.putIfAbsent(i, "val" + i);
        }
        //hashMap.forEach((id, val) -> System.out.println(val));

//        hashMap.computeIfPresent(3, (num, val) -> val + num);
//        System.out.println(hashMap.get(3));
        Map<Map.Entry<Integer, String>, Map.Entry<Integer, String>> collect = hashMap.entrySet().stream().filter(m -> m.getValue().endsWith("0")).collect(Collectors.toMap(e -> e, e -> e));
        collect.forEach((id, val) -> System.out.println(val.getValue()));
//        hashMap.merge(9, "java", (value, newVal) -> value.concat(newVal));
//        String s = hashMap.get(9);
//        System.out.println(s);
    }

    @Test
    public void testStreamList() {
        List<String> list = new ArrayList<>();
        list.add("ddd2");
        list.add("aaa2");
        list.add("bbb1");
        list.add("aaa1");
        list.add("bbb3");
        list.add("ccc");
        list.add("bbb2");
        list.add("ddd1");
        String reduce = list.stream().reduce(("A"), (a, b) -> a + "#" + b);
        System.out.println(reduce);
    }

    @Test
    public void testStream() {

    }

}
