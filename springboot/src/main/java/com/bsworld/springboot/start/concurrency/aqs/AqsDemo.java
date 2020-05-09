package com.bsworld.springboot.start.concurrency.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-20 14:52
 * description:
 */
public class AqsDemo extends AbstractQueuedSynchronizer {
    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }
}
