package com.bsworld.springboot.start.http;

import com.bsworld.springboot.start.util.FileUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-10-23 13:42
 * description:
 */
@RestController()
@RequestMapping("/hs")
public class HttpServerController {

    AtomicLong al = new AtomicLong(0);
    AtomicInteger ai = new AtomicInteger(0);

    @PostMapping(value = "/ts")
    public String run1(HttpServletResponse response) throws InterruptedException {
        long start = System.currentTimeMillis();
        response.addHeader("Connection","keep-alive");
        Thread.sleep(50);
        long end = System.currentTimeMillis();
        long sum = al.addAndGet(end - start);
        int i = ai.incrementAndGet();
        System.out.println("server 平均耗时:" + sum / i + "-----sum:" + sum +"-------ai:" + i);
        return "hello world";
    }
    public static void main(String[] args) {

    }
}
