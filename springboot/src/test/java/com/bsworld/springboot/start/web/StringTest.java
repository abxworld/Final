package com.bsworld.springboot.start.web;
/*
*author: xieziyang
*date: 2018/7/20
*time: 15:02
*description:
*/

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class StringTest {
    @Test
    public void run1() {
        String a = "12345678";
        String substring = a.substring(4, 8);
        System.out.println(substring);
    }

    @Test
    public void run2() {
        List<Object> list = Arrays.asList("hello", "world");
        HashMap<String, Object> hashMap = Maps.newHashMap();
        HashMap<String, String> aMap = Maps.newHashMap();
        hashMap.put("other", list);
        System.out.println(JSON.toJSONString(JSON.toJSONString(hashMap)));
        //System.out.println(JSON.toJSONString(aMap));
    }

    @Test
    public void run3() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\a.d");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        Hello hello = new Hello();
        hello.setAge(10);
        hello.setName("world");
        hello.setSex("0");
        hello.setDate(new Date());
        oos.writeObject(hello);
    }

    @Test
    public void run4() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("D:\\a.d");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Hello object = (Hello) ois.readObject();
        System.out.println(JSON.toJSONString(object));
    }

    @Test
    public void run5() {
        Ordering<Comparable> natural = Ordering.natural();
        LocalDate date1 =  LocalDate.of(2018,1,24);
        LocalDate date2 =  LocalDate.of(2018,1,25);
        LocalDate max = natural.max(date1, date2);
       // System.out.println(max);
        Integer min = natural.min(11, 2);
      //  System.out.println(min);
        String compare = natural.min("Aa", "AA");
       // System.out.println(compare);

        List<Integer> list = Arrays.asList(1, 2, 3, 23, 12, 56, 12);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 23, 12, 100, 12);
        Integer min1 = natural.max(natural.max(list), natural.max(list2));
        System.out.println(min1);
    }

    public static void main(String[] args) {
        String a = "0.1235";
        boolean numeric = isNumeric(a);
        System.out.println(numeric);
    }
    public static boolean isNumeric(String str) {
        String trim = str.trim();
        for (int i = 0; i <trim.length() ; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
