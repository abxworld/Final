package com.bsworld.springboot.start.uniq_id;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-10-25 14:21
 * description:
 */
public class TimeCallBack {
    private static String callBackCode;
    private static AtomicInteger ai = new AtomicInteger(0);

    public static String getCallBackCode() {
        if (callBackCode == null || callBackCode.isEmpty()) {
            synchronized (ai) {
                if (callBackCode == null || callBackCode.isEmpty()) {
                    int code = ai.get();
                    callBackCode = wrapperString(code);
                }
            }
        }
        return callBackCode;
    }


    public static String incrCallBackCode() {
        //重置codeBackCode
        callBackCode = null;
        ai.incrementAndGet();
        return getCallBackCode();
    }


    private static String wrapperString(int para) {
        String wrapperV = String.valueOf(para);
        if (para < 10) {
            wrapperV = "0" + para;
        }
        return wrapperV;
    }

}
