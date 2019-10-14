package com.bsworld.springboot.start.web;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * BASE64的工具类 更换成调用jdk8 的高性能安全Base64 放弃sun.misc下的base64
 * 
 * @author smartlv
 */
public class BASE64Coding
{
    public BASE64Coding()
    {
    }

    /**
     * 按系统默认编码encode该字符串
     * 
     * @param s
     * @return String
     */
    public static String encode(String s)
    {
        return java.util.Base64.getEncoder().encodeToString(s.getBytes());
    }

    /**
     * 对字节数组进行encode
     * 
     * @param bytes
     * @return String
     */
    public static String encode(byte[] bytes)
    {
        return java.util.Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 对ByteBuffer进行encode
     * 
     * @param buf
     * @return String
     */
    public static String encode(ByteBuffer buf)
    {
        return getString(java.util.Base64.getEncoder().encode(buf));
    }

    /**
     * ByteBuffer 转换 String
     * 
     * @param buffer
     * @return
     */
    public static String getString(ByteBuffer buffer)
    {
        Charset charset = null;
        CharsetDecoder decoder = null;
        CharBuffer charBuffer = null;
        try
        {

            charset = Charset.forName("UTF-8");
            decoder = charset.newDecoder();
            // charBuffer = decoder.decode(buffer);//用这个的话，只能输出来一次结果，第二次显示为空
            charBuffer = decoder.decode(buffer.asReadOnlyBuffer());
            return charBuffer.toString();
        }
        catch (Exception ex)
        {
            return "";
        }
    }

    /**
     * 对BASE64的字符串进行decode，若decode失败，则返回null
     * 
     * @param str
     * @return byte[]
     */
    public static byte[] decode(String str)
    {
        try
        {
            return java.util.Base64.getDecoder().decode(str);
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
