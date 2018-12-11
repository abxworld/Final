package com.bsworld.springboot.start.redis;

import com.google.common.collect.Lists;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

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
       String[] keys = new String[1000];
        for (int i = 0; i < 1000; i++) {
            if (i <= 5) {
                keys[i] = String.valueOf((i + 1000));
            }else {
                keys[i] = String.valueOf(i + 10);
            }
        }
        Integer oldVal = -1;
        Integer newVal = 0;
        List<String> mget = jedis.mget(keys);
        for (String s : mget) {
            System.out.println(s);
//            newVal = Integer.valueOf(s);
//            oldVal = newVal;
        }
    }
}
