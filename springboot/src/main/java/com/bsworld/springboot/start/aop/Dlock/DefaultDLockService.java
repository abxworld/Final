package com.bsworld.springboot.start.aop.Dlock;

import org.springframework.stereotype.Component;

/**
 * program: fianl
 * author: bsworld.xie
 * create: 2020-01-10 14:25
 * description:
 */
@Component
public class DefaultDLockService implements DLockService {
    @Override
    public boolean lock(String key, String value, long expireTime) {
        return true;
    }

    @Override
    public boolean releaseLock(String key, String value) {
        return true;
    }
}
