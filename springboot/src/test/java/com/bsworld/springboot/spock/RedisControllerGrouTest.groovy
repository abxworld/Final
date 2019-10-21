package com.bsworld.springboot.spock

import com.bsworld.springboot.basic.MyBean
import com.bsworld.springboot.start.redis.JedisConnection
import com.bsworld.springboot.start.redis.JedisMock
import com.bsworld.springboot.start.web.RedisController
import org.apache.zookeeper.ZooKeeper
import redis.clients.jedis.Jedis
import spock.lang.Specification

/**
 * program: Final 
 * author: bsworld.xie 
 * create: 2019-10-05 21:40 
 * description: 
 */
class RedisControllerGrouTest extends Specification {
    Jedis jedis
    RedisController redisController
    ZooKeeper zooKeeper

    def setup() {
        jedis = JedisConnection.getJedis()
        redisController = new RedisController()
        zooKeeper = Mock(ZooKeeper)
        redisController.zooKeeper = zooKeeper
        redisController.jedis = jedis
    }

    def "test redis set"() {
        System.out.println(jedis);
        given:
        zooKeeper.equals(_) >> true

        Map hashMap = Maps.newHashMap();
        hashMap.put("1006", "happy");
        when:
        def result = redisController.set(hashMap)
        then:
        result == "OK"
    }


    def "test mock call"() {
        //["call one","call two", "call three","call four"]
        given:
        JedisMock jedisMock = Mock(JedisMock)
        redisController.jedisMock = jedisMock
        MyBean myBean = new MyBean("hello",100l)
        MyBean myBean1 = new MyBean("hello",100l)
        jedisMock.invoke(map) >> "ok"
        when:

        def invoke = redisController.invoke(map1)
        System.out.println(invoke);
        then:
       invoke.equals("ok")

    }

}
