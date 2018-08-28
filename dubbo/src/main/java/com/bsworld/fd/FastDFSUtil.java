package com.bsworld.fd;
/*
*author: xieziyang
*date: 2018/7/5
*time: 9:42
*description:
*/

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerServer;

import java.net.SocketTimeoutException;
import java.util.HashMap;

public class FastDFSUtil {

    private final Log log = LogFactory.getLog("FastDfsUtil.class");
    /**
     * 连接池
     */
    private FastDFSFastDFSConnectionPool connectionPool = null;
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

    public FastDFSUtil() {
        init();
    }

    /**
     * 初始化线程池
     *
     * @Description:
     */


    public void init() {

        log.info("[初始化线程池(Init)[默认参数：minPoolSize=" + minPoolSize + ",maxPoolSize=" + maxPoolSize + ",waitTimes="
                + waitTimes + "]");
        connectionPool = new FastDFSFastDFSConnectionPool(minPoolSize, maxPoolSize, waitTimes);
    }

    public String upload(FastDFSFile file, NameValuePair[] valuePairs) throws FastException {
        /** 封装文件信息参数 */
        TrackerServer trackerServer = null;
        try {

            /** 获取fastdfs服务器连接 */
            trackerServer = connectionPool.checkout();
            StorageServer storageServer = null;
            StorageClient1 client = new StorageClient1(trackerServer, storageServer);

            String[] results = client.upload_file(file.getContent(), file.getExt(), valuePairs);

            /** 上传完毕及时释放连接 */
            connectionPool.checkin(trackerServer);

            log.info("[上传文件（upload）-fastdfs服务器相应结果][result：results=" + results + "]");

            /** results[0]:组名，results[1]:远程文件名 */
            if (results != null && results.length == 2) {
                return /*ReadProperties.getFile_ip() +*/ "/" + results[0] + "/" + results[1];
            } else {
                /** 文件系统上传返回结果错误 */
                throw FastDFSERROR.UPLOAD_RESULT_ERROR.ERROR();
            }
        } catch (FastException e) {

            log.error("[上传文件（upload)][异常：" + e + "]");
            throw e;

        } catch (SocketTimeoutException e) {
            log.error("[上传文件（upload)][异常：" + e + "]");

            //将连接数减一
            connectionPool.drop(trackerServer);

            throw FastDFSERROR.WAIT_IDLECONNECTION_TIMEOUT.ERROR();
        } catch (Exception e) {
            log.error("[上传文件（upload)][异常：" + e + "]");
            connectionPool.drop(trackerServer);
            throw FastDFSERROR.SYS_ERROR.ERROR();

        }

    }


    /**
     * @param group_name      组名
     * @param remote_filename 远程文件名称
     * @throws FastException
     * @Description: 删除fastdfs服务器中文件
     */
    public void deleteFile(String group_name, String remote_filename) throws FastException {
        log.info("[ 删除文件（deleteFile）][parms：group_name=" + group_name + ",remote_filename=" + remote_filename + "]");
        TrackerServer trackerServer = null;

        try {
            /** 获取可用的tracker,并创建存储server */
            trackerServer = connectionPool.checkout();
            StorageServer storageServer = null;
            StorageClient1 client1 = new StorageClient1(trackerServer, storageServer);
            /** 删除文件,并释放 trackerServer */
            int result = client1.delete_file(group_name, remote_filename);

            /** 上传完毕及时释放连接 */
            connectionPool.checkin(trackerServer);

            log.info("[ 删除文件（deleteFile）--调用fastdfs客户端返回结果][results：result=" + result + "]");

            /** 0:文件删除成功，2：文件不存在 ，其它：文件删除出错 */
            if (result == 2) {

                throw FastDFSERROR.NOT_EXIST_FILE.ERROR();

            } else if (result != 0) {

                throw FastDFSERROR.DELETE_RESULT_ERROR.ERROR();

            }

        } catch (FastException e) {

            log.error("[ 删除文件（deleteFile）][异常：" + e + "]");
            throw e;

        } catch (SocketTimeoutException e) {
            log.error("[ 删除文件（deleteFile）][异常：" + e + "]");
            throw FastDFSERROR.WAIT_IDLECONNECTION_TIMEOUT.ERROR();
        } catch (Exception e) {

            log.error("[ 删除文件（deleteFile）][异常：" + e + "]");
            connectionPool.drop(trackerServer);
            throw FastDFSERROR.SYS_ERROR.ERROR();

        }
    }

    /**
     * @param fileId
     * @return
     */
    public String getOriginFileName(String fileId) {
        TrackerServer trackerServer = null;
        String originFileName = null;
        try {
            trackerServer = connectionPool.checkout();
            StorageServer storageServer = null;
            StorageClient1 client = new StorageClient1(trackerServer, storageServer);
            String groupName = "group1";
            String remoteFileName = fileId;
            NameValuePair[] metadata = client.get_metadata(groupName, remoteFileName);
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            for (NameValuePair metadatum : metadata) {
                hashMap.put(metadatum.getName(), metadatum.getValue());
            }
            originFileName = (String) hashMap.get("fileName");
        } catch (Throwable t) {
            log.warn("get origin name failed");
        }
        return originFileName;
    }

    public FastDFSFastDFSConnectionPool getConnectionPool() {
        return connectionPool;
    }

    public void setConnectionPool(FastDFSFastDFSConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public long getMinPoolSize() {
        return minPoolSize;
    }

    public void setMinPoolSize(long minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public long getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(long maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public long getNowPoolSize() {
        return nowPoolSize;
    }

    public void setNowPoolSize(long nowPoolSize) {
        this.nowPoolSize = nowPoolSize;
    }

    public long getWaitTimes() {
        return waitTimes;
    }

    public void setWaitTimes(long waitTimes) {
        this.waitTimes = waitTimes;
    }
}