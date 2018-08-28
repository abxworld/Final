package com.bsworld.springboot.start.web;

/*
*author: xieziyang
*date: 2018/7/23
*time: 16:39
*description:
*/

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.HashMap;

public class MySqlControllerTest {
    @Test
    public void rh(){
        String type = MediaType.APPLICATION_JSON_VALUE;
        String url = "http://localhost:8080/mysql";
        HttpUtil.sendPost(url, null, type);
    }

    @Test
    public void rh0(){
        String type = MediaType.APPLICATION_JSON_VALUE;
        String url = "http://localhost:8080/json";
        HashMap<Object, Object> hashMap = Maps.newHashMap();
        hashMap.put("a", "A");
        hashMap.put("b", "B");
        hashMap.put("c", "C");
        HttpUtil.sendPost(url, JSON.toJSONString(hashMap), type);
    }
}