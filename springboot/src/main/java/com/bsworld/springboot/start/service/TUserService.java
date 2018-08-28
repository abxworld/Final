package com.bsworld.springboot.start.service;
/*
*author: xieziyang
*date: 2018/7/30
*time: 18:03
*description:
*/

import com.bsworld.springboot.start.dao.entity.TUser;

public interface TUserService {
    TUser queryTUserBuLoginName(String loginName);
}
