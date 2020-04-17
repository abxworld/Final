package com.bsworld.springboot.start.proxy.jdkNew;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-17 15:26
 * description:
 */
//被代理的类
public class UserServiceImpl implements UserService {
    @Override
    public void add(String something) {
        System.out.println("add(), something:" + something);
    }

    @Override
    public void update(Long uid) {
        System.out.println("update(), uid:" + uid);
    }
}
