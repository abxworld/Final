package com.bsworld.mock;
/*
*author: xieziyang
*date: 2018/7/7
*time: 11:08
*description:
*/

import org.csource.fastdfs.TrackerServer;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.concurrent.Executors.newScheduledThreadPool;

/**
 * @author bsworld
 */
public class BeatHeart {
    private ConnectionPool pool;
    public static AtomicInteger count = new AtomicInteger(0);

    public BeatHeart(ConnectionPool pool) {
        this.pool = pool;
        initBeat();
    }

    public void initBeat() {
        ScheduledExecutorService service = newScheduledThreadPool(1);
        service.scheduleWithFixedDelay(() -> {
            TrackerServer trackerServer = null;
            trackerServer = pool.getPoolTracker();
            if (trackerServer != null) {
                pool.poolCheck(trackerServer);
            } else {
                pool.decreNowPoolSize();
                if (pool.getNowPooSize() < pool.getMinPoolSize()) {
                    pool.createConnection();
                }
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

}
