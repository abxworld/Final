package com.bsworld.nio.queue;
/*
*author: xieziyang
*date: 2018/4/26
*time: 19:10
*description:
*/

public class InnerClass {
    String b = "this is a old day";

    public static void main(String[] args) {
        new InnerClass().run0();
    }
    public void run0() {
        final Student student = new Student();
        student.setUsername("hello");
        student.setPassword("word");
        final String a = "this is a new day";
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(b.length());
                System.out.println(a.length());
            }
        }).start();
        System.out.println(student.toString());
    }
}
