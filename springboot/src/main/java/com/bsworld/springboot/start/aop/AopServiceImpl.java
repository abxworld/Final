package com.bsworld.springboot.start.aop;
/*
*author: xieziyang
*date: 2018/7/10
*time: 15:52
*description:
*/

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AopServiceImpl implements AopService {

    private static List<User> list = null;

    static {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("name" + i);
            user.setPass("pass" + i);
            list.add(user);
        }
    }

    @Cacheable(value = "user", key = "#name")
    @Override
    public User selectUser(String name) {
        System.out.println("\n real query \n");
        List<User> allUser = this.getAllUser();
        User user = allUser.stream().filter(m -> m.getName().equals(name)).findFirst().get();
        return user;
    }

    @CachePut(value = "user", key = "#name")
    @Override
    public User update(String name, String pass) {
        System.out.println("\n UPDATE \n");
        List<User> allUser = this.getAllUser();
        User user = allUser.stream().filter(m -> m.getName().equals(name)).findFirst().get();
        user.setPass(pass);
        return user;
    }

    @Cacheable(value = "allUser", key = "'keyUser'")
    @Override
    public List<User> selectAllUser() {
        System.out.println("start all \n");
        return list;
    }

    @CachePut(value = "allUser", key = "'keyUser'")
    @Override
    public List<User> updateUser(String name, String pass) {
        User user = list.stream().filter(m -> m.getName().equals(name)).findFirst().get();
        user.setPass(pass);
        return list;
    }


    public List<User> getAllUser() {

        return list;
    }
}
