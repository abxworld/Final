package com.bsworld.nio.annotation;

import java.lang.annotation.*;

/*
*author: xieziyang
*date: 2018/5/12
*time: 19:03
*description:
*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    public enum Color{GREEN,WHITE,BLACK,BLUE}
    Color fruitColor() default Color.GREEN;
}
