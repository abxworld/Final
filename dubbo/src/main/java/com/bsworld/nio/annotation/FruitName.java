package com.bsworld.nio.annotation;

import java.lang.annotation.*;

/*
*author: xieziyang
*date: 2018/5/12
*time: 19:00
*description:
*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "apple";
}
