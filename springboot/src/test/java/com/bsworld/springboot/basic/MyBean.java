package com.bsworld.springboot.basic;

import org.springframework.stereotype.Component;

/*
*author: xieziyang
*date: 2018/7/4
*time: 9:40
*description:
*/
@Component
public class MyBean {
    private String username = "100";
    private Long age;
    public MyBean() {
    }

    public MyBean(String username, Long age) {
        this.username = username;
        this.age = age;
    }

    public MyBean(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
