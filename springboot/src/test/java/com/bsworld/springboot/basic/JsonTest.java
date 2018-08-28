package com.bsworld.springboot.basic;
/*
*author: xieziyang
*date: 2018/8/16
*time: 19:59
*description:
*/

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;

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
}
