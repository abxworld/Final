package com.bsworld.springboot.synchronixed;

import org.junit.Test;

public class SynTest {
    public static void main(String[] args) {
        //测试结果表明父类的方法是被子类继承了的
        Child child  = new Child();
        child.doSomeThing();
    }

}
