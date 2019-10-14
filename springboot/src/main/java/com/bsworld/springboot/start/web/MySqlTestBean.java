package com.bsworld.springboot.start.web;

import java.io.Serializable;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2018-12-29 17:34
 * description:
 */
public class MySqlTestBean implements Serializable {
    private String userName;
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

    @Override
    public String toString() {
        return "MySqlTestBean{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
