package com.bsworld.springboot.basic;
/*
*author: xieziyang
*date: 2018/8/6
*time: 13:49
*description:
*/

import com.alibaba.fastjson.JSON;
import com.bsworld.springboot.start.web.Hello;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.HashMap;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal(1);
        BigDecimal b1 = new BigDecimal("0.1");
        BigDecimal subtract = b.subtract(b1).setScale(8);
        System.out.println(subtract);
    }

    @Test
    public void run2() {
        Hello h  = new Hello();
        h.setName("username");
        HashMap<Object, Object> hashMap = Maps.newHashMap();
        BeanUtils.copyProperties(h, hashMap);
        System.out.println(JSON.toJSONString(hashMap));
    }
}
