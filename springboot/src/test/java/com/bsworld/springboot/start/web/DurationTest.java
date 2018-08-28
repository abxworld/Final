package com.bsworld.springboot.start.web;
/*
*author: xieziyang
*date: 2018/7/4
*time: 9:56
*description:
*/

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class DurationTest {
    @Test
    public void rh() {
        String type = MediaType.APPLICATION_JSON_VALUE;
        WithDrawAddReq req = new WithDrawAddReq();
        req.setRateType((short)3);
        List<? extends Serializable> hello = Arrays.asList("hello", 10,10);
        req.setList(hello);
        String url = "http://localhost:8080/hello";
        String s = HttpUtil.sendPost(url, JSON.toJSONString(req), type);
        System.out.println("s::::" + s);
    }

    @Test
    public void run1() {
       String a  = "bsworld";
        byte[] encode = Base64.getEncoder().encode(a.getBytes());
        System.out.println(String.valueOf(encode));
    }
}
