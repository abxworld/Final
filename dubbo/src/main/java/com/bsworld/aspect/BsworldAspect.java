package com.bsworld.aspect;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/*
*author: xieziyang
*date: 2018/7/8
*time: 23:27
*description:
*/
 @Component
public class BsworldAspect {

    @Cacheable
    public void run() {

    }
}
