package com.bsworld.springboot.synchronixed;

import java.lang.reflect.Field;

public class PrivateExtendTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Child child = new Child();
        Class<? extends Child> childClass = child.getClass();
        Field[] fields = childClass.getDeclaredFields();
        Field[] declaredFields = childClass.getSuperclass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
        }

        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }

    }
}
