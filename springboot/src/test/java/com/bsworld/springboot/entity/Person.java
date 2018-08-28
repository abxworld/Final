/*
package com.bsworld.springboot.entity;
*/
/*
*author: xieziyang
*date: 2018/8/2
*time: 10:26
*description:
*//*


import java.util.Date;
import java.util.Random;

public class Person {

    @ExcelCell(priority = 14, cellTitle = "姓名")
    private String name;
    @ExcelCell(priority = 10, cellTitle = "age")
    private int age;
    @ExcelCell(priority = 11, cellTitle = "性别")
    private Sex sex;
    @ExcelCell(priority = 25, cellTitle = "生日")
    private Date birthDay;

    public static Person getDemoPerson() {
        Date date = new Date();
        date.setTime(date.getTime() - new Random().nextInt(10000) * 1000 * 10000);
        Person person = new Person("Tom", new Random().nextInt(100), Sex.man, date);
        return person;
    }

    public enum Sex {
        man,
        woman;
    }
}
*/
