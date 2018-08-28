package com.bsworld.springboot.start.shiro;

/*
*author: xieziyang
*date: 2018/7/30
*time: 20:20
*description:
*/

import com.alibaba.fastjson.JSON;
import com.bsworld.springboot.start.dao.entity.TUser;
import com.bsworld.springboot.start.web.HttpUtil;
import org.junit.Test;
import org.springframework.http.MediaType;

public class ShiroControllerTest {
    @Test
    public void rh() {
        String type = MediaType.APPLICATION_JSON_VALUE;
        TUser tUser = new TUser();
        tUser.setUsername("tom");
        tUser.setPassword("123456");
        String url = "http://localhost:8080/login";
        HttpUtil.sendPost(url, JSON.toJSONString(tUser), type);
    }
}