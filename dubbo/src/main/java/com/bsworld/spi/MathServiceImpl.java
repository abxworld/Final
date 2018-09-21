package com.bsworld.spi;
/*
*author: xieziyang
*date: 2018/5/6
*time: 23:33
*description:
*/

public class MathServiceImpl implements StudyService {
    @Override
    public void hello(String study) {
        System.out.println("Math");
    }

    @Override
    public void adaptiveHello() {
        System.out.println("Math adaptive");
    }
}
