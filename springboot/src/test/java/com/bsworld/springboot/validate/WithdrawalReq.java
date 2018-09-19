package com.bsworld.springboot.validate;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class WithdrawalReq implements Serializable {

    private static final long serialVersionUID = 6794518737248827933L;
    /**
     * 提现最小时间 时间戳
     */
    //private Long minWithDate;
    /**
     * 提现最大时间 时间戳
     */
    private List<Long> withDate;
    /**
     * 提现商户号
     */
    private String merchantNo;
    /**
     * 提现币种
     */
    private String currency;
    /**
     * 提现流水号
     */
    private String withFlowNo;
    private String transferTranSeq;
    /**
     * 提现审核状态
     */
    private Integer auditStatus;
    /**
     * 审核最大时间 时间戳
     */
    private List<Long> auditDate;
    /**
     * 审核最小时间 时间戳
     */
    //private Long minAuditDate;

    /**
     * 商户标识 商户标识，0：主商户,1：子商户
     */
    private Short merchantType;// 1：主商户,2：子商户
    private Integer page;
    private Integer pageSize;
    private String merName;//商户名称
    private String remark;
    private String auditNode;//审核节点
    private String nextAuditNode;//下一处理流程节点
    private Integer nextAuditStatus;//下一处理流程节点状态
    private String channelNo;
    private String modeFlag;
    private Date startDate;
    private Date endDate;
    private Date startAuditDate;
    private  Date endAuditDate;
    private Long id;
    private String auditRemark;
    private String auditor;//审核人
    private String unpayBankAccNo;//线下提现优付全球出账号
    private String unpayBankTransferFee;///线下提现优付全球出账手续费

    public String getTransferTranSeq() {
        return transferTranSeq;
    }

    public void setTransferTranSeq(String transferTranSeq) {
        this.transferTranSeq = transferTranSeq;
    }

    public String getUnpayBankAccNo() {
        return unpayBankAccNo;
    }

    public void setUnpayBankAccNo(String unpayBankAccNo) {
        this.unpayBankAccNo = unpayBankAccNo;
    }

    public String getUnpayBankTransferFee() {
        return unpayBankTransferFee;
    }

    public void setUnpayBankTransferFee(String unpayBankTransferFee) {
        this.unpayBankTransferFee = unpayBankTransferFee;
    }

    public Integer getNextAuditStatus() {
        return nextAuditStatus;
    }

    public void setNextAuditStatus(Integer nextAuditStatus) {
        this.nextAuditStatus = nextAuditStatus;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getNextAuditNode() {
        return nextAuditNode;
    }

    public void setNextAuditNode(String nextAuditNode) {
        this.nextAuditNode = nextAuditNode;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModeFlag() {
        return modeFlag;
    }

    public void setModeFlag(String modeFlag) {
        this.modeFlag = modeFlag;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartAuditDate() {
        return startAuditDate;
    }

    public void setStartAuditDate(Date startAuditDate) {
        this.startAuditDate = startAuditDate;
    }

    public Date getEndAuditDate() {
        return endAuditDate;
    }

    public void setEndAuditDate(Date endAuditDate) {
        this.endAuditDate = endAuditDate;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getAuditNode() {
        return auditNode;
    }

    public void setAuditNode(String auditNode) {
        this.auditNode = auditNode;
    }

    public Short getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(Short merchantType) {
        this.merchantType = merchantType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public List<Long> getWithDate() {
        return withDate;
    }

    public void setWithDate(List<Long> withDate) {
        this.withDate = withDate;
    }

    public List<Long> getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(List<Long> auditDate) {
        this.auditDate = auditDate;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getWithFlowNo() {
        return withFlowNo;
    }

    public void setWithFlowNo(String withFlowNo) {
        this.withFlowNo = withFlowNo;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getMerName() {
        return merName;
    }

    public void setMerName(String merName) {
        this.merName = merName;
    }


    @Override
    public String toString() {
        return "WithdrawalReq{" +
                "withDate=" + withDate +
                ", merchantNo='" + merchantNo + '\'' +
                ", currency='" + currency + '\'' +
                ", withFlowNo='" + withFlowNo + '\'' +
                ", transferTranSeq='" + transferTranSeq + '\'' +
                ", auditStatus=" + auditStatus +
                ", auditDate=" + auditDate +
                ", merchantType=" + merchantType +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", merName='" + merName + '\'' +
                ", remark='" + remark + '\'' +
                ", auditNode='" + auditNode + '\'' +
                ", nextAuditNode='" + nextAuditNode + '\'' +
                ", nextAuditStatus=" + nextAuditStatus +
                ", channelNo='" + channelNo + '\'' +
                ", modeFlag='" + modeFlag + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startAuditDate=" + startAuditDate +
                ", endAuditDate=" + endAuditDate +
                ", id=" + id +
                ", auditRemark='" + auditRemark + '\'' +
                ", auditor='" + auditor + '\'' +
                ", unpayBankAccNo='" + unpayBankAccNo + '\'' +
                ", unpayBankTransferFee='" + unpayBankTransferFee + '\'' +
                '}';
    }
}
