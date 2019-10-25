package com.bsworld.springboot.start.zookeeper;

import com.bsworld.springboot.start.util.FileUtil;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import static org.apache.zookeeper.Watcher.Event.KeeperState.SyncConnected;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-09-25 17:18
 * description:
 */
public class ZkWatch {
    ZooKeeper zk = null;
    CountDownLatch countDownLatch = new CountDownLatch(1);

    public ZooKeeper getConnection() {
        try {
            String remoteHost = FileUtil.getRemoteHost();
            zk = new ZooKeeper(remoteHost + ":2181", 10, watchedEvent -> {
                System.out.println("watch notice");
                System.out.println(watchedEvent);
                System.out.println(watchedEvent.getType());
                Watcher.Event.EventType type = watchedEvent.getType();
                if (SyncConnected.getIntValue() == watchedEvent.getState().getIntValue()) {
                    countDownLatch.countDown();
                }
                switch (type) {
                    case NodeCreated:
                        System.out.println("path:" + watchedEvent.getPath());
                    case NodeDataChanged:
                        System.out.println("节点更新");
                        System.out.println("path:" + watchedEvent.getPath());
                }
            });
            countDownLatch.await();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return zk;
    }

    public boolean createPath(String path, String data) {
        try {
            //设置监控(由于zookeeper的监控都是一次性的所以 每次必须设置监控)
            zk.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("节点创建成功");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws KeeperException, InterruptedException {
        ZkWatch watch = new ZkWatch();
        ZooKeeper zk = watch.getConnection();
        System.out.println(zk);
        Stat exists = zk.exists("/zookeeper", false);
        System.out.println(exists);

    }


}
