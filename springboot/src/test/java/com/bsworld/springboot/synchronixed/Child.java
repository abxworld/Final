package com.bsworld.springboot.synchronixed;

public class Child extends Parent {
    @Override
    public synchronized void doSomeThing() {
        System.out.println("child this: " + this);
        System.out.println("child");
        super.doSomeThing();
    }
}
