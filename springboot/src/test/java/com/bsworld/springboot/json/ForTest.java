package com.bsworld.springboot.json;

import com.bsworld.springboot.basic.MyBean;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-08-14 16:10
 * description:
 */
public class ForTest {
    public static void main(String[] args) {
        List<MyBean> list = Lists.newArrayList();
        for (long i = 0; i < 30000000; i++) {
            list.add(new MyBean("a" + i, i));
        }
        long start0 = System.currentTimeMillis();
        for (MyBean myBean : list) {

        }
        long end0 = System.currentTimeMillis();
        System.out.println("增强for循环耗时:" + (end0 - start0));
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("fori循环耗时:" + (end1 - start1));
        long start2 = System.currentTimeMillis();
        list.forEach((m -> {
        }));
        long end2 = System.currentTimeMillis();
        System.out.println("for each:" + (end2 - start2));
        long start3 = System.currentTimeMillis();
        list.stream().forEach(m ->{});
        long end3 = System.currentTimeMillis();
        System.out.println("stream each:" + (end3 - start3));
    }
}
