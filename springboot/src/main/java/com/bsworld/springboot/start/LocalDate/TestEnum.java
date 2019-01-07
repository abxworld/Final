package com.bsworld.springboot.start.LocalDate;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2018-12-12 12:20
 * description:
 */
public enum TestEnum {
    UNKNOWN(1, "未知"),
    START(2, "开始");
    TestEnum(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }
   private Integer code;
    private String desc;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }}
