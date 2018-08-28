package com.bsworld.fd;

/*
*author: xieziyang
*date: 2018/7/6
*time: 23:57
*description:
*/

import org.junit.Test;

public class StartTest {

    @Test
    public void run1() {
        String file = "\\group\\hello\\M00";
        String replace = file.replace("\\", "");
        System.out.println(replace);
        String substring = file.substring(file.indexOf("p") + 1);
        System.out.println(substring);
    }

}