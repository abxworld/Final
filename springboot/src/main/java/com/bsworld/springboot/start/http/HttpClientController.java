package com.bsworld.springboot.start.http;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-10-21 20:33
 * description:
 */
@RestController()
@RequestMapping("/hc")
public class HttpClientController {
    AtomicLong al = new AtomicLong(0);
    AtomicInteger ai = new AtomicInteger(0);

    @GetMapping(value = "/tc")
    public String run0() {
        String remoteHost = "127.0.0.1";
        String testPort = "8080";
        String URI = "/hs/ts";
        String URL = "http://" + remoteHost + ":" + testPort + URI;
        System.out.println("test server, URL" + URL);
        long start = System.currentTimeMillis();
        String s = HttpsUtils.executePostMethod(URL, Maps.newHashMap());
        long end = System.currentTimeMillis();
        long sum = al.addAndGet(end - start);
        int i = ai.incrementAndGet();
        System.out.println("平均耗时:" + sum / i);
        System.out.println(s);
        return s;
    }

}
