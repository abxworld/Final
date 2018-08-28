package com.bsworld.mock;
/*
*author: xieziyang
*date: 2018/7/7
*time: 10:42
*description:
*/

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.ProtoCommon;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author bsworld
 */
public class ConnectionPool {
    private final AtomicInteger nowPoolSize = new AtomicInteger(0);
    private static final String CONFIG = "config.properties";
    private int maxPoolSize = 10;
    private int minPoolSize = 3;
    private final ArrayBlockingQueue<TrackerServer> connectionPool = new ArrayBlockingQueue<TrackerServer>(maxPoolSize);
    private final AtomicInteger retryTimes = new AtomicInteger(0);
    private static final int WAIT_TIME = 3;

    public ConnectionPool() {
        try {
            ClientGlobal.init(CONFIG);
            for (int i = 0; i < minPoolSize; i++) {
                createConnection();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public void createConnection() {
        TrackerServer trackerServer = null;
        TrackerClient trackerClient = null;
        try {
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            while (trackerServer == null && retryTimes.get() < 5) {
                System.out.println(("[retry times: ]" + retryTimes.incrementAndGet()));
                ClientGlobal.init(CONFIG);
                trackerClient = new TrackerClient();
                trackerServer = trackerClient.getConnection();
            }
            if (trackerServer != null) {
                boolean validFlag = ProtoCommon.activeTest(trackerServer.getSocket());
                if (validFlag == true) {
                    checkIn(trackerServer);
                    increNowPoolSize();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public TrackerServer checkOut() {
        TrackerServer trackerServer = null;
        try {
            for (int i = 0; i < nowPoolSize.get(); i++) {
                trackerServer = connectionPool.poll(WAIT_TIME, TimeUnit.SECONDS);
                if (trackerServer != null) {
                    this.poolCheck(trackerServer);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return trackerServer;
    }

    public TrackerServer getPoolTracker() {
        TrackerServer trackerServer = null;
        try {
            trackerServer = connectionPool.poll(WAIT_TIME, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return trackerServer;
    }

    public void setPoolTracker(TrackerServer trackerServer) {
        try {
            boolean offer = connectionPool.offer(trackerServer, WAIT_TIME, TimeUnit.SECONDS);
            if (!offer) {
                if (trackerServer != null) {
                    trackerServer.close();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void checkIn(TrackerServer trackerServer) {
        try {
            connectionPool.offer(trackerServer, WAIT_TIME, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void poolCheck(TrackerServer trackerServer) {
        boolean validFlag = false;
        try {
            validFlag = ProtoCommon.activeTest(trackerServer.getSocket());
            if (validFlag) {
                this.setPoolTracker(trackerServer);
            } else {
                trackerServer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void increNowPoolSize() {
        nowPoolSize.getAndIncrement();
    }

    public void decreNowPoolSize() {
        nowPoolSize.getAndDecrement();
    }

    public int getNowPooSize() {
        return nowPoolSize.get();
    }

    public int getMinPoolSize() {
        return minPoolSize;
    }

}
