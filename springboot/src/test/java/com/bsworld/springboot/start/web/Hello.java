package com.bsworld.springboot.start.web;
/*
*author: xieziyang
*date: 2018/7/21
*time: 11:39
*description:
*/

import java.io.Serializable;
import java.util.Date;

public class Hello implements Serializable{
    private static final long serialVersionUID = 1L;
    private String Name;
    private int age;
    private String sex;
  //  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", locale = "zh", timezone = "GMT+8")
    private Date date;
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
