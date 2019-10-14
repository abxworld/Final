package com.bsworld.springboot.QRCodes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-06-06 17:10
 * description:
 */
public class ExceptionTest {
    static Logger logger = LoggerFactory.getLogger(ExceptionTest.class);

    public static void main(String[] args) {
        String a = null;
        for (int i = 0; i < 10000000; i++) {
            try {
                a.endsWith("");
            } catch (NullPointerException e) {
                if (i == 10 || i > 1000000) {
                    logger.error("异常",e);
                }
            }
        }
    }
}
