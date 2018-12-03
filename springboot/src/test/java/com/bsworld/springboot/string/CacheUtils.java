package com.bsworld.springboot.string;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 对redis操作一些封装，以便统一代码风格
 */
public abstract class CacheUtils {
    private static final Logger log = LoggerFactory.getLogger(CacheUtils.class);
    private static final String SEPARATOR = "_";

    /**
     * 根据多个因子生成key的前缀字符串
     *
     * @param factors 生成因子
     */
    public static String genKey(Object... factors) {
        return StringUtil.join(SEPARATOR, Lists.transform(Lists.newArrayList(factors), factor -> {
            checkNotNull(factor);
            if (factor instanceof Date) {
                return ((Date) factor).getTime();
            }
            return factor;
        }).toArray());
    }


    public static String genKeyByAppId(String type, Object... factors) {
        String key = genKey(factors);
        return StringUtil.join(SEPARATOR, key, type);
    }

}