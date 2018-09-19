package com.bsworld.springboot.start.web;

/*
*author: xieziyang
*date: 2018/9/14
*time: 17:41
*description:
*/

import org.junit.Test;
import org.springframework.http.MediaType;

public class RateTransControllerTest {
    @Test
    public void insert() {
        String type = MediaType.APPLICATION_JSON_VALUE;
        String url = "http://localhost:8080/rate/insert";
        HttpUtil.sendPost(url, null, type);
    }
    @Test
    public void query() {
        String type = MediaType.APPLICATION_JSON_VALUE;
        String url = "http://localhost:8080/rate/query";
        HttpUtil.sendPost(url, null, type);
    }

    //threadquer
    @Test
    public void threadquery() {
        String type = MediaType.APPLICATION_JSON_VALUE;
        String url = "http://localhost:8080/rate/threadquery";
        HttpUtil.sendPost(url, null, type);
    }
}