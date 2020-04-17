package com.bsworld.springboot.start.proxy.jdkNew;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-17 15:26
 * description:
 *被代理的接口
 */
public interface UserService {
    public void add(String something);

    public void update(Long uid);
}
