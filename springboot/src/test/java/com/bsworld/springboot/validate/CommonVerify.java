package com.bsworld.springboot.validate;
/*
*author: xieziyang
*date: 2018/8/7
*time: 17:38
*description:
*/

import com.bsworld.springboot.annotion.BNotNull;
import com.mysql.cj.util.StringUtils;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.MapContext;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CommonVerify {

    public static void valid(Object object) {
        try {
            if (object == null) {
                throw new IllegalStateException("valid(), obj is null");
            }
            Class<?> aClass = object.getClass();
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                BNotNull notNull = field.getAnnotation(BNotNull.class);
                if (notNull != null) {
                    if (!StringUtils.isNullOrEmpty(notNull.condition())) {
                        JexlContext context = new MapContext();
                        String fileName = notNull.fieldName();
                        if (!StringUtils.isNullOrEmpty(fileName)) {
                            if (fileName.length() > 1) {
                                String substring0 = fileName.substring(0, 1).toUpperCase();
                                String substring1 = fileName.substring(1);
                                Method method = aClass.getMethod("get" + substring0 + substring1);
                                Object invoke = method.invoke(object);
                                if (invoke == null) {
                                    throw new IllegalStateException(notNull.message());
                                } else if (invoke instanceof String) {
                                    if (StringUtils.isNullOrEmpty((String) invoke)) {
                                        throw new IllegalStateException(notNull.message());
                                    }
                                }
                                boolean flag = false;
                                context.set(notNull.fieldName(), invoke);
                                context.set("flag", flag);
                                String expression = "flag = " + notNull.condition();
                                JexlUtil.execute(expression, context);
                                System.out.println(context.get("flag"));
                            }
                        }
                    }
                }
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VerifyEntity entity = new VerifyEntity();
        entity.setInType((short) 0);
        valid(entity);
    }
}
