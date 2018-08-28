package com.bsworld.springboot.validate;
/*
*author: xieziyang
*date: 2018/8/7
*time: 17:42
*description:
*/


import com.bsworld.springboot.annotion.BNotNull;

public class VerifyEntity {
   /* @BNotNull(message = "银行通道channelNo, can not be null")
    private String channelNo;
    *//*原币种*//*
    @BNotNull(message = "原币种fromCur, can not be null")
    private String fromCur;
    *//*换汇币种*//*
    @BNotNull(message = "换汇币种 toCur, can not be null")
    private String toCur;
    *//*加价类型 0百分比  1点差*/
    @BNotNull(message = "加价类型 inType can not be null")
    private Short inType;
    /*结算汇率加价百分比*/
    @BNotNull(message = "inPricePer can not be null", fieldName = "inType", condition = "inType.intValue() == 0")
    private String inPricePer;
    /*结算汇率加价点差*/
    @BNotNull(message = "inPricePer can not be null", fieldName = "inType", condition = "inType.intValue() == 1")
    private String inPriceAgio;

    /*通道卖出价*/
    private String chlRate;
    /*生效日期*/
    private Long transformDate;
    /*线上线下标识  1-线上 2-线下*/
    private Short OnOffLineFlag;

    public Short getInType() {
        return inType;
    }

    public void setInType(Short inType) {
        this.inType = inType;
    }

    public String getInPricePer() {
        return inPricePer;
    }

    public void setInPricePer(String inPricePer) {
        this.inPricePer = inPricePer;
    }

    public String getInPriceAgio() {
        return inPriceAgio;
    }

    public void setInPriceAgio(String inPriceAgio) {
        this.inPriceAgio = inPriceAgio;
    }

    public String getChlRate() {
        return chlRate;
    }

    public void setChlRate(String chlRate) {
        this.chlRate = chlRate;
    }

    public Long getTransformDate() {
        return transformDate;
    }

    public void setTransformDate(Long transformDate) {
        this.transformDate = transformDate;
    }

    public Short getOnOffLineFlag() {
        return OnOffLineFlag;
    }

    public void setOnOffLineFlag(Short onOffLineFlag) {
        OnOffLineFlag = onOffLineFlag;
    }
}
