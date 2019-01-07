package com.bsworld.springboot.start.web;

import java.io.Serializable;
import java.util.Date;

/**
 * program: parent
 * author: bsworld.xie
 * create: 2018-12-13 14:44
 * description:
 */

public class UserDescribeReq implements Serializable {
    /*
     * 用户uid
     * */
    private Long uid;

    /*
     * 性格
     * */
    private String nature;
    /*
     * 装饰品
     * */

    private String decoration;

    /*
     * 声线
     * */
    private String soundRay;

    /*
     * 星座
     * */
    private Integer constellation;

    /*
     * 身高
     * */
    private Integer height;

    /*
     * 我的本命
     * */
    private String animalYear;

    /*
     * 我的技能
     * */
    private String skillTag;

    /*
     * 我的属性
     * */
    private String propertyTag;

    /*
     * 我的兴趣
     * */
    private String interestTag;

    /*
     * 我的情感
     * */
    private String emotionalTag;

    /*
     * 创建时间
     * */
    private Date createTime;

    /*
     * 更新时间
     * */
    private Date updateTime;

    /*
     *
     * 第三方渠道id,0-红豆
     * */
    private String appId;

    /*
     * -1 默认 0 待审核  1 审核通过  2 审核不通过
     * */
    private Byte authStatus;

    /*
     *
     * 收货地址
     * */
    private String receivingAddr;

    /*
     * 收货手机号
     * */
    private String receivingCellPhone;

    /*
     * 收货人姓名
     * */
    private String receivingName;
    /*
     * 人设信息
     * */
    private String authContent;

    private Integer type;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public String getSoundRay() {
        return soundRay;
    }

    public void setSoundRay(String soundRay) {
        this.soundRay = soundRay;
    }

    public Integer getConstellation() {
        return constellation;
    }

    public void setConstellation(Integer constellation) {
        this.constellation = constellation;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getAnimalYear() {
        return animalYear;
    }

    public void setAnimalYear(String animalYear) {
        this.animalYear = animalYear;
    }

    public String getSkillTag() {
        return skillTag;
    }

    public void setSkillTag(String skillTag) {
        this.skillTag = skillTag;
    }

    public String getPropertyTag() {
        return propertyTag;
    }

    public void setPropertyTag(String propertyTag) {
        this.propertyTag = propertyTag;
    }

    public String getInterestTag() {
        return interestTag;
    }

    public void setInterestTag(String interestTag) {
        this.interestTag = interestTag;
    }

    public String getEmotionalTag() {
        return emotionalTag;
    }

    public void setEmotionalTag(String emotionalTag) {
        this.emotionalTag = emotionalTag;
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

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Byte getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(Byte authStatus) {
        this.authStatus = authStatus;
    }

    public String getReceivingAddr() {
        return receivingAddr;
    }

    public void setReceivingAddr(String receivingAddr) {
        this.receivingAddr = receivingAddr;
    }

    public String getReceivingCellPhone() {
        return receivingCellPhone;
    }

    public void setReceivingCellPhone(String receivingCellPhone) {
        this.receivingCellPhone = receivingCellPhone;
    }

    public String getReceivingName() {
        return receivingName;
    }

    public void setReceivingName(String receivingName) {
        this.receivingName = receivingName;
    }

    public String getAuthContent() {
        return authContent;
    }

    public void setAuthContent(String authContent) {
        this.authContent = authContent;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
