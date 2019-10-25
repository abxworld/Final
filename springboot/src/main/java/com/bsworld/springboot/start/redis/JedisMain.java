package com.bsworld.springboot.start.redis;

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
<<<<<<< HEAD
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
        String key = "testZAddKey";
        HashMap<String, Double> hashMap = Maps.newHashMap();
        hashMap.put("1", new Double(100));
        hashMap.put("2", new Double(200));
        hashMap.put("3", new Double(300));
        hashMap.put("4", new Double(400));
        jedis.zadd(key, hashMap);
=======
//        Jedis jedis = JedisConnection.getJedis();
//        String key = "testZAddKey";
//        HashMap<String, Double> hashMap = Maps.newHashMap();
//        hashMap.put("1", new Double(100));
//        hashMap.put("2", new Double(200));
//        hashMap.put("3", new Double(300));
//        hashMap.put("4", new Double(400));
//        jedis.zadd(key, hashMap);
>>>>>>> 7f2e509b9cc77033a3f55e3194b48265b2d23477
    }
}
