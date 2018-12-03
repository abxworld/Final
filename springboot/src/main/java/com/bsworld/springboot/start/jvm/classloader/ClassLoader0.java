package com.bsworld.springboot.start.jvm.classloader;
/*
 *author: xieziyang
 *date: 2018/10/21
 *time: 10:56
 *description:
 */


public class ClassLoader0 extends ClassLoader {
    private String hello;

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.println();
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        return super.loadClass(name);
    }
}
