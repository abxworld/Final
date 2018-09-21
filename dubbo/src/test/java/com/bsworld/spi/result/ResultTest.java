package com.bsworld.spi.result;

/*
*author: xieziyang
*date: 2018/6/26
*time: 12:39
*description:
*/


import org.junit.Test;

public class ResultTest {

    @Test
    public void run1() {
        StaticResult<Integer> success = StaticResult.success();
        System.out.println(success);
    }

    @Test
    public void run2() {
        Result<Object> success = Result.success();
        System.out.println(success);
    }
}
