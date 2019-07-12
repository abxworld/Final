package com.bsworld.springboot.start.concurrency;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-07-12 19:33
 * description:
 */
public class MyRateLimiter {
    private int permitsPerSecond;
    //标识多少微秒产生一个permit
    private int producePermitMicro;

    private long storedPermits;

    private Object sync = new Object();

    private long previousAcquireMicro;

    //最多存储最大的秒数,比如说最大存储一秒的permit,这样也就是说在桶中最多存储 maxStoreSecond * permitsPerSecond 的令牌
    private long maxStoreSecond;

    public static MyRateLimiter create(int permitsPerSecond) {
        return new MyRateLimiter(permitsPerSecond);
    }

    private MyRateLimiter(int permitsPerSecond) {
        this.permitsPerSecond = permitsPerSecond;
        this.producePermitMicro = 1000 * 1000 / permitsPerSecond;
    }

    public Long acquire(int requestPermits) {
        long nowMicro = System.nanoTime();
        Long waitMicro = reverse(requestPermits, nowMicro);
        return waitMicro;
    }


    public Long reverse(int requestPermits, long nowMicro) {
        long waitMicro;
        synchronized (sync) {
            if (this.previousAcquireMicro == 0) {
                waitMicro = requestPermits * previousAcquireMicro;
            } else {
                this.storedPermits = (nowMicro - previousAcquireMicro) / previousAcquireMicro;
                long maxPermits = maxStoreSecond * permitsPerSecond;
                this.storedPermits = storedPermits > maxPermits ? maxPermits : storedPermits;
                long freshPermits = requestPermits - storedPermits;
                freshPermits = freshPermits < 0 ? 0 : freshPermits;
                waitMicro = freshPermits * producePermitMicro;
                this.previousAcquireMicro = nowMicro;
            }
        }
        return waitMicro;
    }
}
