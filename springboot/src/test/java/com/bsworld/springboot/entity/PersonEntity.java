package com.bsworld.springboot.entity;
/*
*author: xieziyang
*date: 2018/8/2
*time: 15:35
*description:
*/

import javax.validation.constraints.NotNull;

public class PersonEntity {

    private Integer age;
    @NotNull
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
