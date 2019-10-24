package com.bsworld.springboot.start.http;

import com.bsworld.springboot.start.util.FileUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-10-23 13:42
 * description:
 */
@RestController()
@RequestMapping("/hs")
public class HttpServerController {
    @PostMapping(value = "/ts")
    public String run1() throws InterruptedException {
        Thread.sleep(50);
        return "hello world";
    }
    public static void main(String[] args) {


    }
}
