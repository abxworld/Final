package com.bsworld.springboot.start.web;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-06-02 15:53
 * description:
 */
public class SubT extends AbstractT {
    @Override
    protected void do2() {
        System.out.println("sub end");
    }

    protected void test() {
        super.test();
        this.doSomething();
        System.out.println("---------------");
        super.doSomething();
    }

    public static void main(String[] args) {
        AbstractT t = new SubT();

        t.test();
    }
}
