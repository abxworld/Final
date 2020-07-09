package com.bsworld.springboot.start.web;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.Map;

/*
*author: xieziyang
*date: 2018/8/7
*time: 11:57
*description:
*/

public class UserControllerTest {
    @Test
    public void rh(){
        String type = MediaType.APPLICATION_JSON_VALUE;
        String url = "http://127.0.0.1:8080/user/get";
        Map hashMap = Maps.newHashMap();
        hashMap.put("page", 0);
        HttpUtil.sendPost(url, JSON.toJSONString(hashMap), type);
    }
}