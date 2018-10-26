package com.bsworld.springboot.start.aop;
/*
*author: xieziyang
*date: 2018/7/10
*time: 15:51
*description:
*/

import java.math.BigDecimal;

public class User {
    private String name;
    private String pass;
    private Short age;
    private BigDecimal score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", pass='").append(pass).append('\'');
        sb.append(", age=").append(age);
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
