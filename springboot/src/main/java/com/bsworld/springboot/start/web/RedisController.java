package com.bsworld.springboot.start.web;

import com.alibaba.fastjson.JSON;
import com.bsworld.springboot.start.util.Logger;
import com.bsworld.springboot.start.util.LoggerFactory;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-10-05 21:31
 * description:
 */
@RequestMapping("/redis")
@RestController
public class RedisController {
    private static final Logger logger = LoggerFactory.getLogger();
    @Autowired
    public Jedis jedis;
    @Autowired
    public ZooKeeper zooKeeper;

    @PostMapping("/set")
    @ResponseBody
    public String set(@RequestBody Map<String, String> keyValues) throws KeeperException, InterruptedException {
        System.out.println("RedisController.class,set(),keyValues:" + JSON.toJSONString(keyValues));
        Set<Map.Entry<String, String>> entries = keyValues.entrySet();
        String[] keyValueArr = new String[keyValues.size() * 2];
        int i = 0;
        for (Map.Entry<String, String> entry : entries) {
            keyValueArr[i] = entry.getKey();
            i++;
            keyValueArr[i] = entry.getValue();
            i++;
        }
        System.out.println("RedisController.class,set(),keyValueArr:" + JSON.toJSONString(keyValueArr));
        boolean exists = zooKeeper.equals("zookee");
        String result = null;
        if (exists) {
            result = jedis.set("a", String.valueOf(new Random().nextInt() * 100000));
        } else {
            result = jedis.set("b", String.valueOf(new Random().nextInt()));
        }

        return result;
    }


    public void invoke() {
        for (int i = 0; i < 5; i++) {
            String result = zooKeeper.toString();
            System.out.println("output:" + result);
        }
    }

    public boolean hello() {
        return false;
    }
}
