package com.bsworld.springboot.start.jvm;
/*
*author: xieziyang
*date: 2018/10/20
*time: 23:40
*description:
*/

public class OutOfStack {
    public static void main(String[] args) {
        new OutOfStack().stack();
    }

    public void stack(){
        System.out.println("invoke");
        stack();
    }
}
