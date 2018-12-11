/*
package com.bsworld.springboot.start.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

*/
/**
 * program: Final
 * author: bsworld.xie
 * create: 2018-12-11 16:59
 * description:
 *//*

public class JedisFactory {
    private static final String HOST = "47.95.117.211";
    private static final int PORT = 6379;
    private JedisPool jedisPool;

    private void init() {
       */
/* GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setTestOnBorrow(url.getParameter("test.on.borrow", true));
        config.setTestOnReturn(url.getParameter("test.on.return", false));
        config.setTestWhileIdle(url.getParameter("test.while.idle", false));
        if (url.getParameter("max.idle", 0) > 0) {
            config.setMaxIdle(url.getParameter("max.idle", 0));
        }
        if (url.getParameter("min.idle", 0) > 0) {
            config.setMinIdle(url.getParameter("min.idle", 0));
        }
        if (url.getParameter("max.active", 0) > 0) {
            config.setMaxTotal(url.getParameter("max.active", 0));
        }
        if (url.getParameter("max.total", 0) > 0) {
            config.setMaxTotal(url.getParameter("max.total", 0));
        }
        if (url.getParameter("max.wait", 0) > 0) {
            config.setMaxWaitMillis(url.getParameter("max.wait", 0));
        }
        if (url.getParameter("num.tests.per.eviction.run", 0) > 0) {
            config.setNumTestsPerEvictionRun(url.getParameter("num.tests.per.eviction.run", 0));
        }
        if (url.getParameter("time.between.eviction.runs.millis", 0) > 0) {
            config.setTimeBetweenEvictionRunsMillis(url.getParameter("time.between.eviction.runs.millis", 0));
        }
        if (url.getParameter("min.evictable.idle.time.millis", 0) > 0) {
            config.setMinEvictableIdleTimeMillis(url.getParameter("min.evictable.idle.time.millis", 0));
        }*//*

        jedisPool = new JedisPool(HOST, PORT);
    }

    public Jedis getJedis() {
        return jedisPool.getResource();
    }
}
*/
