package com.bsworld.springboot.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2018-12-04 20:35
 * description:
 */
public class JsonTestBean {
    @JsonProperty("u")
    private String userName;
    @JsonProperty("p")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
