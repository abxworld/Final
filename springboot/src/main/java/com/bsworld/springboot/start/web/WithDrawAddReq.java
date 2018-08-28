package com.bsworld.springboot.start.web;
/*
*author: xieziyang
*date: 2018/7/2
*time: 14:33
*description:
*/

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class WithDrawAddReq implements Serializable {
    /* *//*结算模式 (0:归集结算，1:独立结算)  冗余数据*//*
    @NotNull(message = "settPattern can not be null")
    private Short settPattern;

    private String cid;
        *//*商户号*//*

    private String merNo;
    *//*currencyNo*//*
    @NotBlank
    private String currencyNO;
    *//*currencyCode*//*
    @NotBlank
    private String currencyCode;
    *//*费率类型 1 百分比  2固定值  3混合费率*/
    @NotNull
    @Max(value = 3, message = "rateType must greater or equals 1 r less than 3 or equals 3")
    @Min(value = 1)
    private Short rateType;

    @Size(max = 3, min = 1, message = "LIST")
    private List list;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Short getRateType() {
        return rateType;
    }

    public void setRateType(Short rateType) {
        this.rateType = rateType;
    }
}
