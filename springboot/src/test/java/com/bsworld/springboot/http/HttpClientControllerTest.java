package com.bsworld.springboot.http;

import com.bsworld.springboot.start.web.HttpUtil;
import org.junit.Test;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-10-23 13:54
 * description:
 */
public class HttpClientControllerTest {
    @Test
    public void run1() {
        String res = HttpUtil.sentGetRequest("application/json","http://127.0.0.1:8080/hc/tc");
        System.out.println(res);
    }
}
