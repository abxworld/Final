package com.bsworld.fd;
/*
*author: xieziyang
*date: 2018/7/5
*time: 9:45
*description:
*/


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class FastDFSFastDFSConnectionPool {
    private final Log log = LogFactory.getLog("FastDFSFastDFSConnectionPool.class");
    /**
     * 空闲的连接池
     */
    private LinkedBlockingQueue<TrackerServer> idleFastDFSConnectionPool = null;
    /**
     * 连接池默认最小连接数
     */
    private long minPoolSize = 10;
    /**
     * 连接池默认最大连接数
     */
    private long maxPoolSize = 30;
    /**
     * 当前创建的连接数
     */
    private volatile long nowPoolSize = 0;
    /**
     * 默认等待时间（单位：秒）
     */
    private long waitTimes = 20;
    /**
     * fastdfs客户端创建连接默认1次
     */
    private static final int COUNT = 3;

    public static final String CLIENT_CONFIG_FILE = "config.properties";

    /**
     * 默认构造方法
     */
    public FastDFSFastDFSConnectionPool(long minPoolSize, long maxPoolSize, long waitTimes) {

        log.info("[线程池构造方法(FastDFSConnectionPool)][" + "][默认参数：minPoolSize=" + minPoolSize + ",maxPoolSize="
                + maxPoolSize + ",waitTimes=" + waitTimes + "]");
        this.minPoolSize = minPoolSize;
        this.maxPoolSize = maxPoolSize;
        this.waitTimes = waitTimes;
        /** 初始化连接池 */
        poolInit();
        /** 注册心跳 */
        FastDFSHeartBeat beat = new FastDFSHeartBeat(this);
        beat.beat();
    }

    /**
     * @Description: 连接池初始化 (在加载当前FastDFSConnectionPool时执行) 1).加载配置文件
     * 2).空闲连接池初始化； 3).创建最小连接数的连接，并放入到空闲连接池；
     */
    private void poolInit() {
        try {
            /** 加载配置文件 */
            initClientGlobal();
            /** 初始化空闲连接池 */
            idleFastDFSConnectionPool = new LinkedBlockingQueue<TrackerServer>();
            /** 往线程池中添加默认大小的线程 */
            for (int i = 0; i < minPoolSize; i++) {
                createTrackerServer(COUNT);
            }
        } catch (Exception e) {

        }
    }

    /**
     * @Description: 创建TrackerServer, 并放入空闲连接池
     */
    public void createTrackerServer(int flag) {

        TrackerServer trackerServer = null;

        try {

            TrackerClient trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            while (trackerServer == null && flag < 5) {
                log.info("[创建TrackerServer(createTrackerServer)][第" + flag + "次重建]");
                flag++;
                initClientGlobal();
                trackerServer = trackerClient.getConnection();
            }
            org.csource.fastdfs.ProtoCommon.activeTest(trackerServer.getSocket());
            idleFastDFSConnectionPool.add(trackerServer);
            /** 同一时间只允许一个线程对nowPoolSize操作 **/
            synchronized (this) {
                nowPoolSize++;
            }

        } catch (Exception e) {

            log.error("[创建TrackerServer(createTrackerServer)][异常：{}]", e);

        } finally {

            if (trackerServer != null) {
                try {
                    trackerServer.close();
                } catch (Exception e) {
                    log.error("[创建TrackerServer(createTrackerServer)--关闭trackerServer异常][异常：{}]", e);
                }
            }

        }
    }

    /**
     * @throws AppException
     * @Description: 获取空闲连接 1).在空闲池（idleFastDFSConnectionPool)中弹出一个连接；
     * 2).把该连接放入忙碌池（busyFastDFSConnectionPool）中; 3).返回 connection
     * 4).如果没有idle connection, 等待 wait_time秒, and check again
     */
    public TrackerServer checkout() throws FastException {

        log.info("[获取空闲连接(checkout)]");
        TrackerServer trackerServer = idleFastDFSConnectionPool.poll();

        if (trackerServer == null) {

            if (nowPoolSize < maxPoolSize) {
                createTrackerServer(COUNT);
                try {
                    trackerServer = idleFastDFSConnectionPool.poll(waitTimes, TimeUnit.SECONDS);
                } catch (Exception e) {
                    log.error("[获取空闲连接(checkout)-error][error:获取连接超时:{}]", e);
                    throw FastDFSERROR.WAIT_IDLECONNECTION_TIMEOUT.ERROR();
                }
            }
            if (trackerServer == null) {
                log.error("[获取空闲连接(checkout)-error][error:获取连接超时（" + waitTimes + "s）]");
                throw FastDFSERROR.WAIT_IDLECONNECTION_TIMEOUT.ERROR();
            }

        }
        log.info("[获取空闲连接(checkout)][获取空闲连接成功]");
        return trackerServer;

    }

    /**
     * @param
     * @Description: 释放繁忙连接 1.如果空闲池的连接小于最小连接值，就把当前连接放入idleFastDFSConnectionPool；
     * 2.如果空闲池的连接等于或大于最小连接值，就把当前释放连接丢弃；
     */

    public void checkin(TrackerServer trackerServer) {

        log.info("[释放当前连接(checkin)][prams:" + trackerServer + "] ");
        if (trackerServer != null) {
            if (idleFastDFSConnectionPool.size() < minPoolSize) {
                idleFastDFSConnectionPool.add(trackerServer);
            } else {
                synchronized (this) {
                    if (nowPoolSize != 0) {
                        nowPoolSize--;
                    }
                }
            }
        }

    }

    /**
     * @param trackerServer
     * @Description: 删除不可用的连接，并把当前连接数减一（调用过程中trackerServer报异常，调用一般在finally中）
     */
    public void drop(TrackerServer trackerServer) {
        log.info("[删除不可用连接方法(drop)][parms:" + trackerServer + "] ");
        if (trackerServer != null) {
            try {
                synchronized (this) {
                    if (nowPoolSize != 0) {
                        nowPoolSize--;
                    }
                }
                trackerServer.close();
            } catch (IOException e) {
                log.info("[删除不可用连接方法(drop)--关闭trackerServer异常][异常：{}]", e);
            }
        }
    }

    private void initClientGlobal() throws Exception {
        String classPath = FastDFSFastDFSConnectionPool.class.getResource("/").getPath().replaceAll("%20", " ");// 项目真实路径
        String fdfsClientConfigFilePath = classPath + CLIENT_CONFIG_FILE;// FastDFS客户端配置文件
        ClientGlobal.init(fdfsClientConfigFilePath);
    }

    public LinkedBlockingQueue<TrackerServer> getIdleFastDFSConnectionPool() {
        return idleFastDFSConnectionPool;
    }

    public long getMinPoolSize() {
        return minPoolSize;
    }

    public void setMinPoolSize(long minPoolSize) {
        if (minPoolSize != 0) {
            this.minPoolSize = minPoolSize;
        }
    }

    public long getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(long maxPoolSize) {
        if (maxPoolSize != 0) {
            this.maxPoolSize = maxPoolSize;
        }
    }

    public long getWaitTimes() {
        return waitTimes;
    }

    public void setWaitTimes(int waitTimes) {
        if (waitTimes != 0) {
            this.waitTimes = waitTimes;
        }
    }

}