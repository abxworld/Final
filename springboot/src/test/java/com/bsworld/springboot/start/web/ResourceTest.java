package com.bsworld.springboot.start.web;
/*
*author: xieziyang
*date: 2018/7/25
*time: 10:12
*description:
*/

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class ResourceTest {
    @Test
    public void run1() {
        try {
        /*    ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream asStream = loader.getResourceAsStream("application.properties");
            Properties props = new Properties();
            props.load(asStream);
            String property = props.getProperty("server.port");
            Assert.assertNotNull(property);
            Assert.assertNotNull(property);
            System.out.println(property);*/
            File file = new File("application.properties");
            InputStream inputStream = new FileInputStream(file);
            Properties props = new Properties();
            props.load(inputStream);
            Object o = props.get("server.port");
            System.out.println(JSON.toJSONString(o));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void run2() {
        List<String> list0 = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        List<String> collect = list1.stream().filter(m -> list0.stream().noneMatch(n -> n.equals(m))).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void run3() {
    String a = "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";
        byte[] decode = Base64.getDecoder().decode(a.getBytes());
        System.out.println(new String(decode));
    }

    @Test
    public void run4() {
        String message = "hello";
        byte[] encode = Base64.getEncoder().encode(message.getBytes());
        byte[] decode = Base64.getDecoder().decode(encode);
        System.out.println(new String(decode));
    }
}
