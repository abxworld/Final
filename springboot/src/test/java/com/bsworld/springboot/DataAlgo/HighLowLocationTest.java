package com.bsworld.springboot.DataAlgo;

import com.bsworld.springboot.start.web.HttpUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-06-04 13:55
 * description:
 */
public class HighLowLocationTest {
    public static void main(String[] args) {
        long now = System.currentTimeMillis() / 1000;
        System.out.println(now);
        System.out.println(Long.toBinaryString(now));
        System.out.println(Long.toBinaryString(now).length());
        long days = 2;
        days = days << 32;
        long cat = now + days;

        days = cat >> 32;
        System.out.println(days);
        days = days << 32;
        now = cat - days;
        System.out.println(now);

    }
}
