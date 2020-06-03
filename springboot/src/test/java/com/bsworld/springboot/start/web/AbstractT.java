package com.bsworld.springboot.start.web;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-06-02 15:52
 * description:
 */
public class AbstractT {
    protected void doSomething() {
        System.out.println("abstract start");
        do2();
    }
    protected void test() {
        System.out.println("abstract test()");
    }
    protected void do2() {
        System.out.println("abstract end");
    }
}
