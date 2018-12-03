package com.bsworld.springboot.string;

import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 字符串处理工具集 全部为静态方法
 *
 * @author smartlv
 */
public abstract class StringUtil {
    /**
     * UTF-8编码常量
     */
    public static final String ENC_UTF8 = "UTF-8";
    /**
     * GBK编码常量
     */
    public static final String ENC_GBK = "GBK";
    /**
     * GBK的Charset
     */
    public static final Charset GBK = Charset.forName("GBK");
    /**
     * UTF-8的Charset
     */
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    /**
     * 精确到秒的日期时间格式化的格式字符串
     */
    public static final String FMT_DATETIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取字符型参数，若输入字符串为null，则返回设定的默认值
     *
     * @param str      输入字符串
     * @param defaults 默认值
     * @return 字符串参数
     */
    public static String convertString(String str, String defaults) {
        if (str == null) {
            return defaults;
        } else {
            return str;
        }
    }

    /**
     * 获取int参数，若输入字符串为null或不能转为int，则返回设定的默认值
     *
     * @param str      输入字符串
     * @param defaults 默认值
     * @return int参数
     */
    public static int convertInt(String str, int defaults) {
        if (str == null) {
            return defaults;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return defaults;
        }
    }

    /**
     * 获取long型参数，若输入字符串为null或不能转为long，则返回设定的默认值
     *
     * @param str      输入字符串
     * @param defaults 默认值
     * @return long参数
     */
    public static long convertLong(String str, long defaults) {
        if (str == null) {
            return defaults;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            return defaults;
        }
    }

    /**
     * 获取double型参数，若输入字符串为null或不能转为double，则返回设定的默认值
     *
     * @param str      输入字符串
     * @param defaults 默认值
     * @return double型参数
     */
    public static double convertDouble(String str, double defaults) {
        if (str == null) {
            return defaults;
        }
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            return defaults;
        }
    }

    /**
     * 获取short型参数，若输入字符串为null或不能转为short，则返回设定的默认值
     *
     * @param str      输入字符串
     * @param defaults 默认值
     * @return short型参数
     */
    public static short convertShort(String str, short defaults) {
        if (str == null) {
            return defaults;
        }
        try {
            return Short.parseShort(str);
        } catch (Exception e) {
            return defaults;
        }
    }

    /**
     * 获取float型参数，若输入字符串为null或不能转为float，则返回设定的默认值
     *
     * @param str      输入字符串
     * @param defaults 默认值
     * @return float型参数
     */
    public static float convertFloat(String str, float defaults) {
        if (str == null) {
            return defaults;
        }
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
            return defaults;
        }
    }

    /**
     * 获取boolean型参数，若输入字符串为null或不能转为boolean，则返回设定的默认值
     *
     * @param str      输入字符串
     * @param defaults 默认值
     * @return boolean型参数
     */
    public static boolean convertBoolean(String str, boolean defaults) {
        if (str == null) {
            return defaults;
        }
        try {
            return Boolean.parseBoolean(str);
        } catch (Exception e) {
            return defaults;
        }
    }

    /**
     * 分割字符串
     *
     * @param line      原始字符串
     * @param seperator 分隔符
     * @return 分割结果
     */
    public static String[] split(String line, String seperator) {
        if (line == null || seperator == null || seperator.length() == 0) {
            return null;
        }
        ArrayList<String> list = new ArrayList<String>();
        int pos1 = 0;
        int pos2;
        for (; ; ) {
            pos2 = line.indexOf(seperator, pos1);
            if (pos2 < 0) {
                list.add(line.substring(pos1));
                break;
            }
            list.add(line.substring(pos1, pos2));
            pos1 = pos2 + seperator.length();
        }
        // 去掉末尾的空串，和String.split行为保持一致
        for (int i = list.size() - 1; i >= 0 && list.get(i).length() == 0; --i) {
            list.remove(i);
        }
        return list.toArray(new String[0]);
    }

    /**
     * 分割字符串，并转换为int
     *
     * @param line      原始字符串
     * @param seperator 分隔符
     * @param def       默认值
     * @return 分割结果
     */
    public static int[] splitInt(String line, String seperator, int def) {
        String[] ss = StringUtil.split(line, seperator);
        int[] r = new int[ss.length];
        for (int i = 0; i < r.length; ++i) {
            r[i] = StringUtil.convertInt(ss[i], def);
        }
        return r;
    }

    /**
     * 分割字符串，并转换为long
     *
     * @param line      原始字符串
     * @param seperator 分隔符
     * @param def       默认值
     * @return 分割结果
     */
    public static long[] splitLong(String line, String seperator, long def) {
        String[] ss = StringUtil.split(line, seperator);
        long[] r = new long[ss.length];
        for (int i = 0; i < r.length; ++i) {
            r[i] = StringUtil.convertLong(ss[i], def);
        }
        return r;
    }

    public static String join(String separator, Collection c) {
        if (c.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator i = c.iterator();
        sb.append(i.next());
        while (i.hasNext()) {
            sb.append(separator);
            sb.append(i.next());
        }
        return sb.toString();
    }

    public static String join(String separator, String[] s) {
        return StringUtil.joinArray(separator, s);
    }

    public static String joinArray(String separator, Object[] s) {
        if (s == null || s.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s[0]);
        for (int i = 1; i < s.length; ++i) {
            if (s[i] != null) {
                sb.append(separator);
                sb.append(s[i].toString());
            }
        }
        return sb.toString();
    }

    public static String joinArray(String separator, int[] s) {
        if (s == null || s.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s[0]);
        for (int i = 1; i < s.length; ++i) {
            sb.append(separator);
            sb.append(s[i]);
        }
        return sb.toString();
    }

    public static String joinArray(String separator, long[] s) {
        if (s == null || s.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s[0]);
        for (int i = 1; i < s.length; ++i) {
            sb.append(separator);
            sb.append(s[i]);
        }
        return sb.toString();
    }

    public static String join(String separator, Object... c) {
        return StringUtil.joinArray(separator, c);
    }

    /**
     * 字符串全量替换,不适应于正则表达式替换
     *
     * @param s    原始字符串
     * @param src  要替换的字符串
     * @param dest 替换目标
     * @return 结果
     */
    public static String replaceAll(String s, String src, String dest) {
        if (s == null || src == null || dest == null || src.length() == 0) {
            return s;
        }
        int pos = s.indexOf(src); // 查找第一个替换的位置
        if (pos < 0) {
            return s;
        }
        int capacity = dest.length() > src.length() ? s.length() * 2 : s.length();
        StringBuilder sb = new StringBuilder(capacity);
        int writen = 0;
        for (; pos >= 0; ) {
            sb.append(s, writen, pos); // append 原字符串不需替换部分
            sb.append(dest); // append 新字符串
            writen = pos + src.length(); // 忽略原字符串需要替换部分
            pos = s.indexOf(src, writen); // 查找下一个替换位置
        }
        sb.append(s, writen, s.length()); // 替换剩下的原字符串
        return sb.toString();
    }

    /**
     * 只替换第一个,不适应于正则表达式替换
     *
     * @param s
     * @param src
     * @param dest
     * @return
     */
    public static String replaceFirst(String s, String src, String dest) {
        if (s == null || src == null || dest == null || src.length() == 0) {
            return s;
        }
        int pos = s.indexOf(src);
        if (pos < 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length() - src.length() + dest.length());

        sb.append(s, 0, pos);
        sb.append(dest);
        sb.append(s, pos + src.length(), s.length());
        return sb.toString();
    }

    /**
     * Returns <tt>true</tt> if s is null or <code>s.trim().length()==0<code>.
     *
     * @author isaacdong
     * @see String#isEmpty()
     */
    public static boolean isEmpty(String s) {
        if (s == null) {
            return true;
        }
        return s.trim().isEmpty();
    }

    public static boolean isNotEmpty(String s) {
        return !StringUtil.isEmpty(s);
    }

    /**
     * @see String#trim()
     */
    public static String trim(String s) {
        if (s == null) {
            return null;
        }
        return s.trim();
    }


    public static String removeAll(String s, String src) {
        return StringUtil.replaceAll(s, src, "");
    }

    /**
     * 以某一长度缩写字符串（1个中文或全角字符算2个长度单位，英文或半角算一个长度单位）. 如果要显示n个汉字的长度，则maxlen= 2* n
     *
     * @param src         utf-8字符串
     * @param maxlen      缩写后字符串的最长长度（1个中文或全角字符算2个单位长度）
     * @param replacement 替换的字符串，该串长度会计算到maxlen中
     * @return String
     */
    public static String abbreviate(String src, int maxlen, String replacement) {

        if (src == null) {
            return "";
        }

        if (replacement == null) {
            replacement = "";
        }

        StringBuffer dest = new StringBuffer(); // 初始值设定为源串

        try {
            maxlen = maxlen - StringUtil.computeDisplayLen(replacement);

            if (maxlen < 0) {
                return src;
            }

            int i = 0;
            for (; i < src.length() && maxlen > 0; ++i) {
                char c = src.charAt(i);
                if (c >= '\u0000' && c <= '\u00FF') {
                    maxlen = maxlen - 1;
                } else {
                    maxlen = maxlen - 2;
                }
                if (maxlen >= 0) {
                    dest.append(c);
                }
            }

            // 没有取完 src 所有字符时，才需要加后缀 ...
            if (i < src.length() - 1) {
                dest.append(replacement);
            }
            return dest.toString();
        } catch (Throwable e) {
            LoggerFactory.getLogger("stringutil").error("abbreviate error: ", e);
        }
        return src;
    }

    /**
     * @param src
     * @param maxlen
     * @return
     */
    public static String abbreviate(String src, int maxlen) {
        return StringUtil.abbreviate(src, maxlen, "");
    }

    /**
     * 将字符串截短,功能与abbreviate()类似 全角字符算一个字,半角字符算半个字,这样做的目的是为了显示的时候排版整齐,因为全角字占的位置要比半角字小
     *
     * @param str
     * @param maxLen
     * @return String
     */
    public static String toShort(String str, int maxLen, String replacement) {
        if (str == null) {
            return "";
        }
        if (str.length() <= maxLen) {
            return str;
        }
        StringBuilder dest = new StringBuilder();
        double len = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '\u0000' && c <= '\u00FF') {// 半角字算半个字
                len += 0.5;
            } else {
                len += 1;
            }
            if (len > maxLen) {
                return dest.toString() + replacement;
            } else {
                dest.append(c);
            }
        }
        return dest.toString();
    }

    public static String toShort(String str, int maxLen) {
        return StringUtil.toShort(str, maxLen, "...");
    }

    /**
     * 计算字符串的显示长度，半角算１个长度，全角算两个长度
     *
     * @param s
     * @return
     */
    public static int computeDisplayLen(String s) {
        int len = 0;
        if (s == null) {
            return len;
        }

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c >= '\u0000' && c <= '\u00FF') {
                len = len + 1;
            } else {
                len = len + 2;
            }
        }
        return len;
    }

    /**
     * 获取字符串的UTF-8编码字节数组
     *
     * @param s
     * @return
     */
    public static byte[] getUTF8Bytes(String s) {
        if (s != null && s.length() >= 0) {
            return s.getBytes(StringUtil.UTF_8);
        }
        return null;
    }

    /**
     * 获取字符串的GBK编码字节数组
     *
     * @param s
     * @return
     */
    public static byte[] getGBKBytes(String s) {
        if (s != null && s.length() >= 0) {
            return s.getBytes(StringUtil.GBK);
        }
        return null;
    }

    /**
     * 获取字节数组的UTF-8编码字符串
     *
     * @param b
     * @return
     * @author quickli
     */
    public static String getUTF8String(byte[] b) {
        if (b != null) {
            return new String(b, StringUtil.UTF_8);
        }
        return null;
    }

    /**
     * 获取字节数组的GBK编码字符串
     *
     * @param b
     * @return
     */
    public static String getGBKString(byte[] b) {
        if (b != null) {
            return new String(b, StringUtil.GBK);
        }
        return null;
    }

    /**
     * 对字符串以 GBK编码方式进行URLEncode
     *
     * @param s
     * @return
     */
    public static String urlEncodeGBK(String s) {
        if (s != null && s.length() > 0) {
            try {
                return URLEncoder.encode(s, StringUtil.ENC_GBK);
            } catch (UnsupportedEncodingException e) {
            }
        }
        return s;
    }

    /**
     * 对字符串以 UTF-8编码方式进行URLEncode
     *
     * @param s
     * @return
     */
    public static String urlEncodeUTF8(String s) {
        if (s != null && s.length() > 0) {
            try {
                return URLEncoder.encode(s, StringUtil.ENC_UTF8);
            } catch (UnsupportedEncodingException e) {
            }
        }
        return s;
    }

    /**
     * 对字符串以 GBK编码方式进行URLDecode
     *
     * @param s
     * @return
     */
    public static String urlDecodeGBK(String s) {
        if (s != null && s.length() > 0) {
            try {
                return URLDecoder.decode(s, StringUtil.ENC_GBK);
            } catch (UnsupportedEncodingException e) {
            }
        }
        return s;
    }

    /**
     * 对字符串以 UTF-8编码方式进行URLDecode
     *
     * @param s
     * @return
     */
    public static String urlDecodeUTF8(String s) {
        if (s != null && s.length() > 0) {
            try {
                return URLDecoder.decode(s, StringUtil.ENC_UTF8);
            } catch (UnsupportedEncodingException e) {
            }
        }
        return s;
    }

    /**
     * 数字转换成字母
     *
     * @param i
     * @return
     */
    public static char getChar(int i) {
        return (char) (64 + i);
    }

    /**
     * 用字符补左边空位，
     *
     * @param character 需要进行补位的字符
     * @param size      字符位数
     * @return
     */
    public static String charsFillSeats(Long character, int size) {
        StringBuffer sb = new StringBuffer();
        int num = Integer.parseInt(character + "");
        sb.append(num);
        for (int i = String.valueOf(num).length(); i < size; i++) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }

    /**
     * 将字符串中的多个连续出现的空白字符删除，只保留一个。如"a b c d"会被处理为"a b c d" @param s @return @throws
     */
    public static String removeRepeatedBlankChar(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s.replaceAll("\\s+", " ");
    }

    /**
     * 移除targetStrBuf中字符串右侧subStr字符串，且把右侧空格移除 @param targetStrBuf @param subStr @throws
     */
    public static void rTrim(StringBuffer targetStrBuf, String subStr) {
        while (targetStrBuf.lastIndexOf(" ") > -1 && targetStrBuf.lastIndexOf(" ") == targetStrBuf.length() - 1
                || targetStrBuf.lastIndexOf("   ") > -1 && targetStrBuf.lastIndexOf("   ") == targetStrBuf.length() - 1) {

            targetStrBuf.delete(targetStrBuf.length() - 1, targetStrBuf.length());
        }

        while (targetStrBuf.lastIndexOf(subStr) > 0
                && targetStrBuf.lastIndexOf(subStr) == targetStrBuf.length() - subStr.length()) {
            targetStrBuf.delete(targetStrBuf.lastIndexOf(subStr), targetStrBuf.length());
        }
    }

    /**
     * 将一个字符串数组，用特定的连接符拼接起来
     *
     * @param arr                    待拼接的字符串数组
     * @param spliter                连接符
     * @param ignoreBlankStringInArr 是否忽略掉数组中的空字符串（即如果某个元素是个空字符串，则不把它拼接到结果字符串中。空字符串是指：null,"", 或者全部字符均为空白字符的字符串。）
     * @return
     */
    public static String concatStringArray(String[] arr, String spliter, boolean ignoreBlankStringInArr) {
        if (arr != null && spliter != null) {
            StringBuilder sb = new StringBuilder("");
            boolean flag = false;

            for (int i = 0; i < arr.length; i++) {
                if (StringUtil.isNotEmpty(arr[i]) || !ignoreBlankStringInArr) {
                    if (flag) {
                        sb.append(spliter);
                    } else {
                        flag = true;
                    }
                    sb.append(arr[i]);
                }
            }

            return sb.toString();
        } else {
            throw new IllegalArgumentException("Invalid argument.");
        }
    }

    /**
     * 判断字符串是否存在
     *
     * @param str
     * @return
     */
    public static boolean isExist(String str) {
        if (str != null && str.trim().length() > 0) {
            return true;
        }
        return false;
    }

    /**
     * 非null字符串去前后空格，把null字符串转换为空。
     *
     * @param s 字符串
     * @return 去前后空格的字符串
     */
    public static String parseNullStr(String s) {
        return s == null ? "" : s.trim();
    }

    /**
     * 使用KPM算法模式匹配字符串，使用方法类似于indexOf
     *
     * @param text    待匹配字符串
     * @param pattern 匹配模式
     * @return 成功返回模式所在位置
     */
    public static int patternMatch(String text, String pattern) {
        if (text != null && pattern != null) {
            KMP kmp = new KMP(pattern);
            int pos = kmp.match(text);
            if (pos == text.length()) {
                pos = -1;
            }
            return pos;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * KMP模式匹配算法实现
     */
    private static class KMP {
        private final String pattern;
        private final int[] next;

        // create Knuth-Morris-Pratt NFA from pattern
        public KMP(String pattern) {
            this.pattern = pattern;
            int M = pattern.length();
            this.next = new int[M];
            int j = -1;
            for (int i = 0; i < M; i++) {
                if (i == 0) {
                    this.next[i] = -1;
                } else if (pattern.charAt(i) != pattern.charAt(j)) {
                    this.next[i] = j;
                } else {
                    this.next[i] = this.next[j];
                }
                while (j >= 0 && pattern.charAt(i) != pattern.charAt(j)) {
                    j = this.next[j];
                }
                j++;
            }
        }

        // 返回pattern在text中第一次出现的位置，否则返回的值等于text的长度
        // simulate the NFA to find match
        public int match(String text) {
            int M = this.pattern.length();
            int N = text.length();
            int i, j;
            for (i = 0, j = 0; i < N && j < M; i++) {
                while (j >= 0 && text.charAt(i) != this.pattern.charAt(j)) {
                    j = this.next[j];
                }
                j++;
            }
            if (j == M) {
                return i - M;
            }
            return N;
        }
    }

    /**
     * 判断字符是否为中文字符
     *
     * @param c
     * @return
     * @date: 2014年1月15日上午11:02:50
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否为中文
     *
     * @param str
     * @return
     * @date: 2014年1月15日上午11:02:33
     */
    public static boolean isChinese(String str) {
        if (null == str) {
            return false;
        }

        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (StringUtil.isChinese(c) == false) {
                return false;
            }
        }
        return true;
    }


}
