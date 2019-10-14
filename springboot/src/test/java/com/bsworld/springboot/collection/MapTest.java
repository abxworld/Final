package com.bsworld.springboot.collection;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-06-17 21:26
 * description:
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = Maps.newHashMap();
        hashMap.put(10,10);
        hashMap.put(20,20);
        hashMap.put(30,30);
        hashMap.put(40,40);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer value = entry.getValue();
            if (value == 10) {
                hashMap.remove(entry.getKey());
            }
        }
        System.out.println(hashMap);
    }
}
