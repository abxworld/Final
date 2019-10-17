package com.bsworld.springboot.start.redis;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-10-08 09:40
 * description:
 */
@Component
public class JedisMock {
    public String invoke(Map<Integer, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String value : map.values()) {
            stringBuilder.append(value);
        }
        return stringBuilder.toString();
    }
}
