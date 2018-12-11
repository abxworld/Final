package com.bsworld.springboot.json;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2018-12-04 20:34
 * description:
 */
public class JsonTest {
    List<String> OforList = new ArrayList<>();
    List<String> OforEachList = new ArrayList<>();
    List<String> OstreamList = new ArrayList<>();
    @Test
    public void run0(){
        JsonTestBean bean = new JsonTestBean();
        bean.setUserName("abx");
        bean.setPassword("bbb");
        System.out.println(JSON.toJSONString(bean));
    }

    public void before(List<String> list) {
        double start  = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(UUID.randomUUID().toString());
        }
        double end = System.currentTimeMillis();
        System.out.println("add cost: " + (end -start) / 1000);
    }

    @Test
    public void run2() {
        double start  = System.currentTimeMillis();
        List<String> forList = new ArrayList<>();
        for (String s : this.OforList) {
            forList.add(s);
        }
        double end = System.currentTimeMillis();
        System.out.println("for cost: " + (end - start) / 1000);
    }

    @Test
    public void forTest() {
        before(OforList);
        double forStart  = System.currentTimeMillis();
        List<String> forList = new ArrayList<>();
        for (String s : this.OforList) {
            forList.add(s);
        }
        double forEnd = System.currentTimeMillis();
        System.out.println("for cost: " + (forEnd - forStart) / 1000);
    }

    @Test
    public void forEachTest() {
        before(OforEachList);
        double forEachStart  = System.currentTimeMillis();
        List<String> forEachList = new ArrayList<>();
        OforEachList.forEach(m -> {
            forEachList.add(m);
        });
        double forEachEnd = System.currentTimeMillis();
        System.out.println("for each cost: " + (forEachEnd - forEachStart) / 1000);
    }

    @Test
    public void streamTest() {
        before(OstreamList);
        double start  = System.currentTimeMillis();
        List<String> streamList = new ArrayList<>();
        OstreamList.stream().forEach(m -> {
            streamList.add(m);
        });
        double end = System.currentTimeMillis();
        System.out.println("stream cost: " + (end - start) / 1000);
    }
}
