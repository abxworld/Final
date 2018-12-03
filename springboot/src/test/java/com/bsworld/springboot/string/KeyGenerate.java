package com.bsworld.springboot.string;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2018-11-28 19:14
 * description:
 */
public class KeyGenerate {
    public static void main(String[] args) {
        String key = CacheUtils.genKeyByAppId("0", "virtual_model_res_bind_key", "1124953102240186371");
        System.out.println(key);

    }
}
