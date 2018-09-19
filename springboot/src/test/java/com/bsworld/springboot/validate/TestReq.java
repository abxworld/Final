package com.bsworld.springboot.validate;/*
*author: xieziyang
*date: 2018/9/17
*time: 16:17
*description:
*/

import java.util.List;

public class TestReq {
    private String auditRemark;
    private Short auditStatus;
    List<WithdrawalReq> listArr;

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    public Short getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Short auditStatus) {
        this.auditStatus = auditStatus;
    }

    public List<WithdrawalReq> getListArr() {
        return listArr;
    }

    public void setListArr(List<WithdrawalReq> listArr) {
        this.listArr = listArr;
    }
}
