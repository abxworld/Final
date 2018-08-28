package com.bsworld.mock;
/*
*author: xieziyang
*date: 2018/7/8
*time: 10:54
*description:
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Start {
    private static String PATH = "C:\\Users\\bsworld\\Pictures\\Screenshots\\hello.png";
    private static String NAME = "hello";

    public static void main(String[] args) {
        FastDFSUtil fastDFSUtil = new FastDFSUtil();
        try {
            FileInputStream fis = new FileInputStream(new File(PATH));
            String upload = fastDFSUtil.upload(fis, PATH);
            System.out.println(upload);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
