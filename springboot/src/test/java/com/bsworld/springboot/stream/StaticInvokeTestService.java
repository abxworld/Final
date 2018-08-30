package com.bsworld.springboot.stream;
/*
*author: xieziyang
*date: 2018/8/30
*time: 15:20
*description:
*/

import java.util.HashMap;

public class StaticInvokeTestService {
    public static HashMap<String,String> hashMap = new HashMap(16);

    public static HashMap<String, String> getHashMap() {
        return hashMap;
    }
}
