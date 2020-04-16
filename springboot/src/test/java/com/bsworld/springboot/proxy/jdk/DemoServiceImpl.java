package com.bsworld.springboot.proxy.jdk;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-16 18:33
 * description:
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public void add(String something) {
        System.out.println("real add, something:" + something);
    }
}
