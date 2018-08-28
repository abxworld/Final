package com.bsworld.springboot.basic;
/*
*author: xieziyang
*date: 2018/8/17
*time: 16:55
*description:
*/

import java.util.HashMap;

public class MapTest {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("a", "a");
        hashMap.put("c", "a");
        hashMap.put("d", "a");
        hashMap.put("e", "a");
        hashMap.forEach((name, value) -> {
            if (name.equals("c")) {
                return;
            }
            System.out.println(name + value);
        });
    }
}
