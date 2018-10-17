package com.bsworld.springboot.basic;
/*
*author: xieziyang
*date: 2018/8/13
*time: 11:28
*description:
*/

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class EqualsTest {
    private static final String Key = "key";
    private String name;

    public EqualsTest() {
    }


    @Test
    public void run1() {
       /* MyBean myBean = new MyBean("a");
        MyBean myBean2 = new MyBean("a");
        boolean equals = myBean.equals(myBean2);
        System.out.println(equals);*/
        String a = "s";
        String b = "s";
        long a0 = 1046461646446464646l;
        long a1 = 1046461646446464646l;
        a.hashCode();
        System.out.println(Objects.equals(a, b));
        System.out.println(Objects.equals(a0, a1));
    }

    @Test
    public void run2() {
        HashMap<Object, Object> hashMap = Maps.newHashMap();
        hashMap.put("a", "10");
        int a = 2 ^ 3;
        System.out.println(a);
    }


    @Test
    public void run3() {
        HashMap<Object, Object> hashMap = Maps.newHashMap();
        Map map = new HashMap(hashMap);
        Map unmodifiableMap = Collections.unmodifiableMap(map);
        unmodifiableMap.put("a", "b");
    }


    @Test
    public void run4() {
        int a = 0;
        a = 10 < 5 ? 1 : 10 > 5 ? 2 : 3;
        System.out.println(a);
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]+.*[0-9]*");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {
       /* String classpath = System.getProperty("user.home");
        System.out.println(classpath);*/
    /*    HashMap hashMap0 = new HashMap();
        hashMap0.put("a", "a");
        HashMap hashMap1 = new HashMap();
        hashMap1.put("a", "a");
        hashMap1.put("b", "a");*/
        MyBean bean0 = new MyBean();
        MyBean bean1 = new MyBean();
        bean0.setUsername("hello0");
        bean1.setUsername("hello0");
        List<MyBean> myBeans = asList(bean0, bean1);
        System.out.println(JSON.toJSONString(myBeans));
        List<HashMap> collect1 = myBeans.stream().map(m ->{
            HashMap hashMap = new HashMap();
            hashMap.put(m.getUsername(), m.getUsername());
            return hashMap;
        }).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect1));
    }



    @Test
    public void run5() {
        String accNo = "123456789";
        String s = enSecAccNo(accNo);
        System.out.println(s);
    }

    private String enSecAccNo(String accNo) {
        String enAccNo = accNo;
        System.out.println(enAccNo.length());
        if (enAccNo != null) {
            if (enAccNo.length() > 7) {
                String substring0 = enAccNo.substring(0, 3);
                String substring1 = enAccNo.substring(enAccNo.length() -4);
                for (int i = 0; i < enAccNo.length() - 7; i++) {
                    substring0 = substring0 + "*";
                }
                enAccNo = substring0 + substring1;
            }
        }
        System.out.println(enAccNo.length());
        return enAccNo;
    }
}
