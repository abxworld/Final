package com.bsworld.springboot.start.aop.Dlock;

/**
 * program: fianl
 * author: bsworld.xie
 * create: 2020-01-10 13:44
 * description:
 */
public interface DLockService {
    /**
     *
     * 加锁
     * @param key 锁key
     * @param expireTime 过期时间
     * */
    boolean lock(String key, String value, long expireTime);

    /**
     * 释放锁
     */

    boolean releaseLock(String key, String value);


}
