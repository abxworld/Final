package com.bsworld.springboot.start.nio.serialize;

import java.io.Serializable;

/**
 * program: fianl
 * author: bsworld.xie
 * create: 2020-01-02 19:54
 * description:
 */
public class SocketToBean implements Serializable {

    private Long fromId;

    private String message;

    private Long toId;

    public Long getFromId() {
        return fromId;
    }

    public SocketToBean() {
    }

    public SocketToBean(Long fromId, String message) {
        this.fromId = fromId;
        this.message = message;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    @Override
    public String toString() {
        return "SocketBean{" +
                "id=" + fromId +
                ", message='" + message + '\'' +
                ", transferId=" + toId +
                '}';
    }
}
