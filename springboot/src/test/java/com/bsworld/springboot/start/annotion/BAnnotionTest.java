package com.bsworld.springboot.start.annotion;
/*
*author: xieziyang
*date: 2018/8/2
*time: 15:57
*description:
*/

import com.bsworld.springboot.annotion.BNotNull;
import com.bsworld.springboot.entity.PersonEntity;
import com.google.common.collect.Maps;
import com.mysql.cj.util.StringUtils;
import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BAnnotionTest {
    @Test
    public void run1() {
        PersonEntity entity = new PersonEntity();
        valid(entity);
    }

    public boolean valid(Object o) {
        Class<?> aClass = o.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotationsByType(BNotNull.class) != null) {
                String name = field.getName();
                String s0 = name.substring(0, 1);
                String s1 = name.substring(1);
                String s = "get" + s0.toUpperCase() + s1;
                try {
                    Method method = aClass.getMethod(s);
                    Object invoke = method.invoke(o);
                    if (invoke instanceof String) {
                        String string = (String) invoke;
                        if (!StringUtils.isNullOrEmpty(string)) {
                            throw new IllegalStateException("parameter error: empty");
                        }
                    } else {
                        if (invoke == null) {
                            throw new IllegalStateException("parameter error: null");
                        }
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }


    @Test
    public void run2() {
        PersonEntity entity = new PersonEntity();

    }


    @Test
    public void run3() {
        evalBoolean("age < 10", Maps.newHashMap());
    }

    public static <T> Boolean evalBoolean(String express, Map<String, T> params) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("java");
        if (params == null) {
            params = new HashMap<String, T>();
        }
        Iterator<Map.Entry<String, T>> iter = params.entrySet().iterator();
        Map.Entry<String, T> entry = null;
        while (iter.hasNext()) {
            entry = iter.next();
            engine.put(entry.getKey(), entry.getValue());
        }
        Boolean result = null;
        try {
            result = (Boolean) engine.eval(express);
        } catch (ScriptException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }
}
