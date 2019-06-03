package com.bsworld.springboot.synchronixed;

public class Parent {
    public String parent;
    public synchronized void doSomeThing() {
        {
            System.out.println("parent this: " + this);
            System.out.println("parent");
        }
    }
}
