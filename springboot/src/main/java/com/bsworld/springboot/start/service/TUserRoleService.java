package com.bsworld.springboot.start.service;
/*
*author: xieziyang
*date: 2018/7/30
*time: 18:15
*description:
*/

import com.bsworld.springboot.start.dao.entity.TUserRole;

import java.util.List;

public interface TUserRoleService {
    List<TUserRole> queryRoleByUserId(Integer userId);
}
