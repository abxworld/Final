package com.bsworld.springboot.start.redis;

import com.alibaba.fastjson.JSON;
import com.bsworld.springboot.start.web.MySqlTestBean;
import com.google.common.collect.Maps;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2018-12-11 17:12
 * description:
 */
public class JedisMain {
    public static void main(String[] args) {
        Jedis jedis = JedisConnection.getJedis();
        String key = "hello";
        String newBean1 = JSON.toJSONString(getNewBean());
        String newBean2 = JSON.toJSONString(getNewBean());

        jedis.sadd(key, newBean1);
        jedis.sadd(key, newBean2);
    }


    public static MySqlTestBean getNewBean() {
        MySqlTestBean mySqlTestBean = new MySqlTestBean();
        mySqlTestBean.setUid(1000l);
        mySqlTestBean.setUserName("jjjj");
        return mySqlTestBean;
    }



}
