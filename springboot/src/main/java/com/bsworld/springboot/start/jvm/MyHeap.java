package com.bsworld.springboot.start.jvm;
/*
*author: xieziyang
*date: 2018/9/26
*time: 10:43
*description:
*/

public class MyHeap {
    public static void main(String[] args) {
        int cal = cal();
        System.out.println(cal);
    }

    private static int cal() {
        int a = (int) 4664466446l;
        return a;
    }
}
