package com.bsworld.springboot.basic;
/*
*author: xieziyang
*date: 2018/8/16
*time: 19:59
*description:
*/

import com.alibaba.fastjson.JSON;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class JsonTest {
    @Test
    public void run1() {
        HashMap hashMap = new HashMap();
        hashMap.put("batchPath", "group1/M00/00/2F/CgoBDlt1VpaAIWYmAAAoy0B5ssE72.xlsx");
        System.out.println(JSON.toJSONString(hashMap));
    }

    @Test
    public void run2() {
        String path = "C:\\Users\\bsworld\\Desktop\\FK_REQ_20180802_001.xlsx";

    }

    public static void main(String[] args) {
        List<Integer> list1 = Lists.newArrayList(1, 222, 39999999, 900);
        List<Integer> list2 = Lists.newArrayList(1, 222, 39999999);
        List<Integer> collect = list1.stream().filter(r1 -> list2.stream().noneMatch(r2 -> r1.equals(r2))).collect(Collectors.toList());
        System.out.println(collect);
    }
}
