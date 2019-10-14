package com.bsworld.springboot.start.redis;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2018-12-11 17:09
 * description:
 */
@Component
public class JedisConnection implements InitializingBean {
    private static final String HOST = "106.13.46.179";
    private static final int PORT = 6379;
    private static JedisPool jedisPool;
    @Override
    public void afterPropertiesSet() throws Exception {

    }
    public static Jedis getJedis() {
        if (jedisPool == null) {
            jedisPool = new JedisPool(HOST, PORT);
        }
        return jedisPool.getResource();
    }
}
