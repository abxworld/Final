package com.bsworld.springboot.basic;
/*
 *author: xieziyang
 *date: 2018/8/17
 *time: 12:36
 *description:
 */

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Test {
    private static String test1 = "value1";
    private static String test2 = "value2";

    private static List<String> getStaticField() throws Exception {
        List<String> result = new ArrayList<String>();

        Field[] fields = Test.class.getDeclaredFields();
        if (fields == null || fields.length <= 0) {
            return result;
        }

        for (Field field : fields) {
            field.setAccessible(true);
            //只获取字符串类型
            if (field.getType() == String.class && Modifier.isStatic(field.getModifiers())) {
                result.add(String.valueOf(field.get(Test.class)));
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {

//        String displayName = TimeZone.getDefault().getDisplayName();
//        System.out.println(displayName);
        Test test = new Test();

    }
}