package com.bsworld.springboot.validate;
/*
*author: xieziyang
*date: 2018/5/2
*time: 11:38
*description:
*/


import com.bsworld.springboot.start.util.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class CommonVerify {
    private static final Logger LOGGER = com.bsworld.springboot.start.util.LoggerFactory.getLogger();

    public static boolean verfiyCommon(Object object) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ParseException {

        return verifyDate(object) && verifyPage(object);
    }

    public static boolean verifyDate(Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ParseException {
        if (object == null) {
            LOGGER.debug("请求参数-为空");
            return false;
        }
        Class<?> clazzc = object.getClass();
        Class clazz = clazzc.getSuperclass();
        Method getTimeRange = clazz.getDeclaredMethod("getTimeRange");
        if (getTimeRange.invoke(object) != null) {
            List<Long> timeList = (List<Long>) getTimeRange.invoke(object);
            if (timeList == null) {
                //时间不是必传项，所以可以为空，如果不return下面会报空指针异常
                return true;
            }
            if (timeList.size() == 0
                    || (timeList.size() == 2 && (timeList.get(0) ==null || timeList.get(1) == null))
                    || timeList.size() == 1
                    ) {
                LOGGER.debug("请求参数-日期-为空或者格式不正确, getTimeRange:  ", getTimeRange);
                return false;
            }
            Method setStartTime = clazz.getDeclaredMethod("setStartTime", Date.class);
            Method setEndTime = clazz.getDeclaredMethod("setEndTime", Date.class);
            Date date0 = new Date(timeList.get(0));
            Date date1 = new Date(timeList.get(1));
            Date startDate;
            Date endDate;
            if (date0.getTime() > date1.getTime()) {
                startDate = date1;
                endDate = date0;
            } else {
                startDate = date0;
                endDate = date1;
            }
            Date finalEndDate = new Date(endDate.getTime());
            setStartTime.invoke(object, startDate);
            setEndTime.invoke(object, finalEndDate);
        }
        return true;
    }

    public static boolean verifyPage(Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (object == null) {
            LOGGER.debug("请求参数-为空, object:", null);
            return false;
        }
        Class<?> dateClass = object.getClass();
        Class clazz = dateClass.getSuperclass();
        Method getPage = clazz.getDeclaredMethod("getPage");
        Object pageObject = getPage.invoke(object);
        Method getPageSize = clazz.getDeclaredMethod("getPageSize");
        Object pageSizeObject = getPageSize.invoke(object);
        if (pageObject == null || pageSizeObject == null) {
            LOGGER.debug("请求参数-page 或 pageSize-为空, page:  ", getPage, "  pageSize:  ", getPageSize);
            return false;
        }
        return true;
    }

    public static boolean isEmpty(Object... objects) {
        final String section = ",  ";
        boolean flag = false;
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("参数错误信息如下:  ");
        for (Object object : objects) {
            if (object == null) {
                stringBuilder.append("第 "+ (i + 1) + "  参数:  null").append(section);
                flag = true;
            } else if (object instanceof String) {
                String string = (String) object;
                if (string.contains(":")) {
                    String[] split = string.split(":");
                    if (split.length == 1) {
                       stringBuilder.append(split[0] + " :  "+ "\"\"").append(section);
                    } else if ( split[1] == null || split[1].equalsIgnoreCase(null) || split[1].trim().equalsIgnoreCase("null") ) {
                        stringBuilder.append(split[0] + " :  "+null).append(section);
                        flag = true;
                    } else if (split[1].trim().equals("")) {
                        stringBuilder.append(split[0] + " :  "+ "\"\"").append(section);
                        flag = true;
                    }
                } else if (((String) object).trim().equals("")) {
                    flag = true;
                    stringBuilder.append("第 "+ (i + 1)+" 参数 : \"\"").append(section);
                }
            }
            i++;
        }
        if (flag) {
            LOGGER.debug(stringBuilder.toString());
        }
        return flag;
    }
}
