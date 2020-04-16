package com.bsworld.springboot.start.uniq_id;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-10-25 14:08
 * description:
 */
public class UniqIdGen {
    private static Long timeMillis = System.currentTimeMillis();
    private static AtomicInteger ai = new AtomicInteger(0);
    //因为指对外暴露一个接口，并且加了锁，所以只需要用stringBuilder即可，不需要用StringBuffer
    private static StringBuilder stringBuilder = new StringBuilder();

    public static synchronized String generator() {
        String uniqId = "";
        try {
            stringBuilder
                    .append(IpNumber.releaseIpCode())
//                    .append("-")
                    .append(get());
            uniqId = stringBuilder.toString();

        } finally {
            stringBuilder = new StringBuilder();
        }
        return uniqId;
    }


    private static String get() {
        String value = "";

        Long nowTime = getNowTime();
        //正常情况
        int code = ai.get();
        if (nowTime >= timeMillis) {
            if (code < 4096) {
                code = ai.incrementAndGet();
            } else {
                code = 0;
                while (true) {
                    Long circleTime = System.currentTimeMillis();
                    if (circleTime > nowTime) {
                        nowTime = circleTime;
                        ai.set(code);
                        break;
                    }
                }
            }

        } else {
            //时钟回拨
            System.out.println("时钟回拨");
            code = 0;
            ai.set(code);
            TimeCallBack.incrCallBackCode();
        }
        getVal(nowTime, code, TimeCallBack.getCallBackCode());
        timeMillis = nowTime;
        return value;
    }


    private static Long getNowTime() {
        Long nowTime = System.currentTimeMillis();
        return nowTime;
    }


    private static void getVal(Long nowTime, int code, String callBacCode) {
        stringBuilder.append(nowTime);
        String paraStr = String.valueOf(code);
        int length = paraStr.length();
        switch (length) {
            case 1:
                paraStr = "000" + paraStr;
                break;
            case 2:
                paraStr = "00" + paraStr;
                break;
            case 3:
                paraStr = "0" + paraStr;
                break;
            default:
                break;
        }
//        stringBuilder.append("--");
        stringBuilder.append(paraStr);
//        stringBuilder.append("--");
        stringBuilder.append(callBacCode);
    }


    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Long start = getNowTime();
        while (true) {
            String generator = generator();
            System.out.println(generator);
            if (set.contains(generator)) {
                throw new IllegalStateException("generator uniq id is same");
            }
            if (getNowTime() - start > 10000) {
                break;
            }
            set.add(generator);
        }
        System.out.println(set.size());
    }
}
