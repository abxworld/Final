package com.bsworld.springboot.start.web;

import org.junit.Test;
import org.springframework.http.MediaType;

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
        String url = "http://localhost:8080/user/get";
        HttpUtil.sendPost(url, null, type);
    }
}