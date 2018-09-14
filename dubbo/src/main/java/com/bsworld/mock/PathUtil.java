package com.bsworld.mock;
/*
*author: xieziyang
*date: 2018/7/8
*time: 10:26
*description:
*/


import com.bsworld.util.StringUtil;
import org.csource.common.NameValuePair;

public class PathUtil {
    private static final String POINT = ".";
    private static final String FILENAME = "FILENAME";

    public static String getExtName(String absoluteFileName) {
        String extName = null;
        if (StringUtil.isNotEmpty(absoluteFileName)) {
            if (absoluteFileName.contains(POINT)) {
                extName = absoluteFileName.substring(absoluteFileName.lastIndexOf(POINT));
            }
            if (extName == null) {
                throw new FastDFSException("can not find file extName");
            }
        } else {
            throw new FastDFSException("absoluteFileName is blank");
        }
        return extName;
    }

    public static NameValuePair[] getNameValuePair(String absoluteFileName) {
        NameValuePair[] pairArray = new NameValuePair[1];
        String fileName = null;
        if (absoluteFileName.contains(POINT)) {
            if (absoluteFileName.contains("\\")) {
                fileName = absoluteFileName.substring(absoluteFileName.indexOf("\\")).substring(0, absoluteFileName.indexOf(POINT));
            } else if (absoluteFileName.contains("\\\\")) {
                fileName = absoluteFileName.substring(absoluteFileName.indexOf("\\\\")).substring(0, absoluteFileName.indexOf(POINT));
            } else if (absoluteFileName.contains("/")) {
                fileName = absoluteFileName.substring(absoluteFileName.indexOf("/")).substring(0, absoluteFileName.indexOf(POINT));
            } else if (absoluteFileName.contains("//")) {
                fileName = absoluteFileName.substring(absoluteFileName.indexOf("//")).substring(0, absoluteFileName.indexOf(POINT));
            }
        }
        NameValuePair pair = new NameValuePair(FILENAME, fileName);
        pairArray[0] = pair;
        return pairArray;
    }
}
