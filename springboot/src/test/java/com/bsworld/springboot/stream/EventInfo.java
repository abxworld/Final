package com.bsworld.springboot.stream;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2018-12-27 15:14
 * description:
 */
public class EventInfo {
    private Long eventId;
    private Date createTime;
    private String name;
    private Integer location;

    public EventInfo(Long eventId, Date createTime, String name, Integer location) {
        this.eventId = eventId;
        this.createTime = createTime;
        this.name = name;
        this.location = location;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }
}
