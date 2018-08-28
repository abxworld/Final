package com.bsworld.springboot.start.aop;
/*
*author: xieziyang
*date: 2018/7/10
*time: 15:51
*description:
*/

import java.util.List;

public interface AopService {
    User selectUser(String name);
    User update(String name, String pass);

    List<User> selectAllUser();

    List<User> updateUser(String name, String pass);
}
