package com.bsworld.springboot.start.service;
/*
*author: xieziyang
*date: 2018/7/30
*time: 18:26
*description:
*/

import com.bsworld.springboot.start.dao.entity.TRole;

import java.util.List;

public interface TRoleService {
    List<TRole> queryTRoleByRoleIdList(List<Integer> roleIds);
}
