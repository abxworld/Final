package com.bsworld.mock;
/*
*author: xieziyang
*date: 2018/7/7
*time: 10:40
*description:
*/

import org.csource.common.MyException;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerServer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author bsworld
 */
@Component
public class FastDFSUtil {
    ConnectionPool pool;

    public FastDFSUtil() {
        initPool();
    }

    public void initPool() {
        pool = new ConnectionPool();
        new BeatHeart(pool);
    }

    public String upload(InputStream is, String absoluteFileName) {
        String fileId = null;
        try {
            byte[] bytes = new byte[is.available()];
            TrackerServer trackerServer = pool.checkOut();
            if (trackerServer != null) {
                StorageServer storageServer = null;
                StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);
                fileId = storageClient1.upload_file1(bytes, PathUtil.getExtName(absoluteFileName), PathUtil.getNameValuePair(absoluteFileName));
                pool.checkIn(trackerServer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return fileId;
    }
}
