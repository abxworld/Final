package com.bsworld.springboot.start.aop.Dlock;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * program: fianl
 * author: bsworld.xie
 * create: 2020-01-10 13:47
 * description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DLock {

    String key() default "";

    long expireTime() default 360;

}
