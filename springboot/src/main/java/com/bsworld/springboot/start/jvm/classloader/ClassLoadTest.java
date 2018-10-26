package com.bsworld.springboot.start.jvm.classloader;
/*
*author: xieziyang
*date: 2018/10/21
*time: 10:57
*description:
*/

public class ClassLoadTest {
    private static String beanName = "com.bsworld.springboot.start.jvm.classloader.LoadClassBean";
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader0 loader0 = new ClassLoader0();
        ClassLoader1 loader1 = new ClassLoader1();
        Class<?> class0 = loader0.loadClass(beanName);
        Class<?> class1 = loader1.loadClass(beanName);
        Object o = class0.newInstance();
        Object o1 = class1.newInstance();
        if (o instanceof LoadClassBean){
            System.out.println("true");
        }
        if (o1 instanceof LoadClassBean) {
            System.out.println("o1 true");
        }

        if (class0.isAssignableFrom(class1)) {
            System.out.println("class true");
        }
    }
}
