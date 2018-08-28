package com.bsworld.springboot.basic;
/*
*author: xieziyang
*date: 2018/8/14
*time: 15:47
*description:
*/

import java.io.Serializable;

public class MerTransferModel implements Serializable {
    /*付款币种*/
    private String payCurrencyCode;
    /*  *//*是否是批量(0 批量  1 单笔)*//*
    private Short isBatch;*/
    /*银行账户*/
    private String accountNumber;
    /*收款方账户币种*/
    private String accCurrencyCode;
    /*金额*/
    private String amount;
    /*账户名称（银行账户名称和受益人公司名称）*/
    private String accountHolderName;
    /*收款方地址*/
    private String benefiAddress;
    /*开户行名称*/
    private String bankName;
    /*开户行地址*/
    private String bankAddress;
    /*银行账户城市*/
    private String benefiCity;
    /*银行代码类型*/
    private String bankCodeType;
    /*银行代码*/
    private String bankCodeValue;
    /*swift银行识别码*/
    private String swiftBic;
    /*银行账户国家 3位国家简称*/
    private String countryAbName;
    /*账户类型*/
    private String benefiEntityType;
    /*注册时间·*/
    private String benefiDob;
    /*备注*/
    private String description;


    public String getPayCurrencyCode() {
        return payCurrencyCode;
    }

    public void setPayCurrencyCode(String payCurrencyCode) {
        this.payCurrencyCode = payCurrencyCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccCurrencyCode() {
        return accCurrencyCode;
    }

    public void setAccCurrencyCode(String accCurrencyCode) {
        this.accCurrencyCode = accCurrencyCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getBenefiAddress() {
        return benefiAddress;
    }

    public void setBenefiAddress(String benefiAddress) {
        this.benefiAddress = benefiAddress;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getBenefiCity() {
        return benefiCity;
    }

    public void setBenefiCity(String benefiCity) {
        this.benefiCity = benefiCity;
    }

    public String getBankCodeType() {
        return bankCodeType;
    }

    public void setBankCodeType(String bankCodeType) {
        this.bankCodeType = bankCodeType;
    }

    public String getBankCodeValue() {
        return bankCodeValue;
    }

    public void setBankCodeValue(String bankCodeValue) {
        this.bankCodeValue = bankCodeValue;
    }

    public String getCountryAbName() {
        return countryAbName;
    }

    public void setCountryAbName(String countryAbName) {
        this.countryAbName = countryAbName;
    }

    public String getBenefiEntityType() {
        return benefiEntityType;
    }

    public void setBenefiEntityType(String benefiEntityType) {
        this.benefiEntityType = benefiEntityType;
    }

    public String getBenefiDob() {
        return benefiDob;
    }

    public void setBenefiDob(String benefiDob) {
        this.benefiDob = benefiDob;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSwiftBic() {
        return swiftBic;
    }

    public void setSwiftBic(String swiftBic) {
        this.swiftBic = swiftBic;
    }
}
