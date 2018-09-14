package com.bsworld.util;


public final class StringUtil  {
    public static boolean isEmpty(String string) {
        if (string == null || "".equals(string.trim())) {
            return true;
        }
        return false;
    }
    public static boolean isNotEmpty(String string) {
        if (string == null || "".equals(string.trim())) {
            return false;
        }
        return true;
    }
}
