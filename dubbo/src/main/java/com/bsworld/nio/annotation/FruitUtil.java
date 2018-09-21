package com.bsworld.nio.annotation;
/*
*author: xieziyang
*date: 2018/5/12
*time: 19:30
*description:
*/

import java.lang.reflect.Field;

public class FruitUtil {
    public static <T> T parseFruitAnnotation(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        if (clazz == null) {
            throw new NullPointerException();
        }
        Field[] fields = clazz.getDeclaredFields();
        String name = null;
        String colorModel = null;
        String providerModel = null;
        T t = clazz.newInstance();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                String value = fruitName.value();
                name = name + value;
                field.set(t,name);
            }else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                FruitColor.Color color = fruitColor.fruitColor();
                colorModel = colorModel + color;
                field.set(t,colorModel);
            }else if (field.isAnnotationPresent(FruitProvider.class)) {
                String address = field.getAnnotation(FruitProvider.class).address();
                int id = field.getAnnotation(FruitProvider.class).id();
                String providerName = field.getAnnotation(FruitProvider.class).name();
                providerModel = address + id + providerName;
                field.set(t,providerModel);
            }
        }
        return t;
    }
}
