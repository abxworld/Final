package com.bsworld.springboot.start.web;
import java.util.Collections;
import java.util.Date;

/*
*author: xieziyang
*date: 2018/7/23
*time: 16:39
*description:
*/

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.List;

public class MySqlControllerTest {
    @Test
    public void rh(){
        String type = MediaType.APPLICATION_JSON_VALUE;
        String url = "http://localhost:8080/mysql/test";
        MySqlTestBean bean = new MySqlTestBean();
        bean.setUserName("nihao");
        HttpUtil.sendPost(url, JSON.toJSONString(bean), type);
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

    @Test
    public void string() {
        List<Integer> tagIds = Collections.emptyList();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < tagIds.size(); i++) {
            builder.append(tagIds.get(i));
            if (i < tagIds.size() - 1) {
                builder.append(",");
            }
        }
        System.out.println(JSON.toJSONString(builder.toString()));
    }
}