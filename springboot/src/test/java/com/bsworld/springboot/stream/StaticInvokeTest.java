package com.bsworld.springboot.stream;
/*
*author: xieziyang
*date: 2018/8/30
*time: 15:19
*description:
*/

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StaticInvokeTest {
    public static void main(String[] args) {
        Class<StaticInvokeTestService> aClass = StaticInvokeTestService.class;
        try {

            Method getHashMap = aClass.getMethod("getHashMap");
            Object invoke = getHashMap.invoke(aClass);
            System.out.println(invoke);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
