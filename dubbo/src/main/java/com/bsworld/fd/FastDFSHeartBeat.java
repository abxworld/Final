package com.bsworld.fd;
/*
*author: xieziyang
*date: 2018/7/5
*time: 9:46
*description:
*/

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csource.fastdfs.TrackerServer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class FastDFSHeartBeat {

    private final Log log = LogFactory.getLog("FastDFSHeartBeat.class");
    /** fastdfs连接池 */
    private FastDFSFastDFSConnectionPool pool = null;
    /** 小时毫秒数 */
    public static int ahour = 1000 * 60 * 5 * 1;
    /** 等待时间 */
    public static int waitTimes = 200;

    public FastDFSHeartBeat(FastDFSFastDFSConnectionPool pool) {
        this.pool = pool;
    }

    /**
     *
     * @Description: 定时执行任务，检测当前的空闲连接是否可用，如果不可用将从连接池中移除
     *
     */
    public void beat() {
        log.info("执行心跳方法");
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                log.info("执行检测连接方法");
                LinkedBlockingQueue<TrackerServer> idleConnectionPool = pool.getIdleFastDFSConnectionPool();
                TrackerServer ts = null;
                for (int i = 0; i < idleConnectionPool.size(); i++) {
                    try {
                        ts = idleConnectionPool.poll(waitTimes, TimeUnit.SECONDS);
                        if (ts != null) {
                            org.csource.fastdfs.ProtoCommon.activeTest(ts.getSocket());
                            idleConnectionPool.add(ts);
                        } else {
                            /** 代表已经没有空闲长连接 */
                            break;
                        }
                    } catch (Exception e) {
                        /** 发生异常,要删除，进行重建 */
                        log.error("重新设置文件连接");
                        pool.drop(ts);
                    }
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, ahour, ahour);
    }

}
