package com.bsworld.springboot.enumc;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ThirdChannelType
{
    HONGDOU("0", "红豆"),
    UXIN("82", "有信"),
    WEILIVE("93","微商"),
    PAOPAO("99", "泡泡语音"),
    KLIVE("666","日本版Kilakila");

    private String key;
    private String value;

    private ThirdChannelType(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }

    private static final Map<String, ThirdChannelType> lookup = new HashMap<String, ThirdChannelType>();
    static
    {
        for (ThirdChannelType s : EnumSet.allOf(ThirdChannelType.class))
            lookup.put(s.getKey(), s);
    }

    public static ThirdChannelType get(String key)
    {
        return lookup.get(key);
    }
    public static void main(String[] args) {

        System.out.println(ThirdChannelType.lookup);
    }
}

