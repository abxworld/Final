package com.bsworld.springboot.random;
/*
*author: xieziyang
*date: 2018/9/12
*time: 14:10
*description:
*/

import com.alibaba.fastjson.JSON;
import com.bsworld.springboot.basic.MyBean;
import org.junit.Test;

import java.util.UUID;

public class UUIDTest {
    @Test
    public void run1() {
        UUID uuid = UUID.randomUUID();
        UUID uuid0 = UUID.randomUUID();
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();
        String replace = uuid.toString().replace("-", "");
        String replace0 = uuid0.toString().replace("-", "");
        String replace1 = uuid1.toString().replace("-", "");
        String replace2 = uuid2.toString().replace("-", "");
        System.out.println(replace + "  flow size: " + replace.length());
        System.out.println(replace0 + "  flow size: " + replace.length());
        System.out.println(replace1 + "  flow size: " + replace.length());
        System.out.println(replace2 + "  flow size: " + replace.length());
    }

    @Test
    public void run2() {
        for (int i = 0; i < 10; i++) {
            if (i == 10) {
                break;
            }
        }
    }

    @Test
    public void run3() {
        MyBean bean = new MyBean();
        bean.setUsername("hello");
        bean.setAge(10l);
        JSON.toJSON(bean);
    }

    @Test
    public void run4() {
        int i = 8 >>> 1;
        System.out.println(i);
    }
}
