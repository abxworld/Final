package com.bsworld.springboot.start.uniq_id;

import java.util.Date;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-10-25 18:01
 * description:
 */
public class IPCodeInfo {
    Long id;

    String ipAddress;

    String code;

    Date createTime;

    Date updateTime;

    Date idleTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getIdleTime() {
        return idleTime;
    }

    public void setIdleTime(Date idleTime) {
        this.idleTime = idleTime;
    }

    @Override
    public String toString() {
        return "IPCodeInfo{" +
                "id=" + id +
                ", ipAddress='" + ipAddress + '\'' +
                ", code='" + code + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", idleTime=" + idleTime +
                '}';
    }
}
