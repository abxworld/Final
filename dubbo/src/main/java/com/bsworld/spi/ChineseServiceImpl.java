package com.bsworld.spi;
/*
*author: xieziyang
*date: 2018/5/6
*time: 23:35
*description:
*/

public class ChineseServiceImpl implements StudyService {
    @Override
    public void hello(String study) {
        System.out.println("Chinese");
    }

    @Override
    public void adaptiveHello() {
        System.out.println("Chinese adaptive");
    }
}
