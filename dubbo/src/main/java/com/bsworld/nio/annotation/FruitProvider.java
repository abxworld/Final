package com.bsworld.nio.annotation;

import java.lang.annotation.*;

/*
*author: xieziyang
*date: 2018/5/12
*time: 19:06
*description:
*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    int id() default 0;
    String name() default "";
    String address() default "";
}
