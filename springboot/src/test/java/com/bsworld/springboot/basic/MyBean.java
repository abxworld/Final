package com.bsworld.springboot.basic;

import org.apache.jute.InputArchive;
import org.apache.jute.OutputArchive;
import org.apache.jute.Record;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;

/*
*author: xieziyang
*date: 2018/7/4
*time: 9:40
*description:
*/
@Component
public class MyBean implements Serializable, Record {
    private String username;
    private String password;
    private Long age;
    public MyBean() {
    }

    public MyBean(String username, Long age) {
        this.username = username;
        this.age = age;
    }

    public MyBean(String username, String password, Long age) {
        this.username = username;
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        int result = getUsername() != null ? getUsername().hashCode() : 0;
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        MyBean myBean0 = new MyBean();
        MyBean myBean1 = new MyBean();
        System.out.println(myBean0.equals(myBean1) );
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void serialize(OutputArchive outputArchive, String tag) throws IOException {
        outputArchive.startRecord(this,tag);
        outputArchive.writeString(username, "username");
        outputArchive.writeLong(age, "age");
        outputArchive.endRecord(this,tag);
    }

    @Override
    public void deserialize(InputArchive inputArchive, String tag) throws IOException {
        inputArchive.startRecord(tag);
        inputArchive.readString("username");
        inputArchive.readLong("age");
        inputArchive.endRecord(tag);
    }
}
