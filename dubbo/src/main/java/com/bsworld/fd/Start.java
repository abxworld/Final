package com.bsworld.fd;
/*
*author: xieziyang
*date: 2018/7/5
*time: 12:25
*description:
*/

import org.csource.common.NameValuePair;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author bsworld
 */
public class Start {
    private static String PATH = "C:\\Users\\bsworld\\Pictures\\Screenshots\\hello.png";
    private static String NAME = "hello";

    public static void main(String[] args) throws IOException, FastException {
        FastDFSUtil fastDFSUtil = FastDFSFactory.newInstance();
        FileInputStream fis = new FileInputStream(new File(PATH));
        byte[] bytes = new byte[fis.available()];
        fis.read(bytes, 0, bytes.length);
        String fileExtName = null;
        if (PATH.contains(".")) {
            //fileExtName = PATH.substring(PATH.lastIndexOf("." + 1));
            fileExtName = "png";
        } else {
            throw new IllegalStateException("can not find file extention name");
        }
        FastDFSFile fastDFSFile = new FastDFSFile(bytes, NAME, fileExtName, "");
        NameValuePair[] metaList = new NameValuePair[1];
        metaList[0] = new NameValuePair("fileName", NAME);
 //       String upload = fastDFSUtil.upload(fastDFSFile, metaList);
        String groupName = "M00/00/00/wKjRiVs_kneAJtHRAA7_RkhnwQ0000.png";
        String originFileName = fastDFSUtil.getOriginFileName(groupName);
        System.out.println("originFileName:  " + originFileName);
    }
}
