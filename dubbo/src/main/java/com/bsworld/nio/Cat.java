package com.bsworld.nio;/*
*author: xieziyang
*date: 2018/7/3
*time: 22:07
*description:
*/

public class Cat extends Animal {
    private String eyesColor;
    public Cat(String name, String eyesColor) {
        super(name);
        this.eyesColor = eyesColor;
    }

    public static void main(String[] args) {
        Cat cat = new Cat("hello", "redEyes");
    }
}
