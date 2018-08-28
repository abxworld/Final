package com.bsworld.fd;
/*
*author: xieziyang
*date: 2018/7/5
*time: 9:58
*description:
*/

public class FastDFSFactory {
    public static FastDFSUtil newInstance() {
        FastDFSUtil fastDFSUtil = new FastDFSUtil();
        return fastDFSUtil;
    }
}
