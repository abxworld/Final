package com.bsworld.springboot.start.service;
/*
*author: xieziyang
*date: 2018/7/30
*time: 19:45
*description:
*/

import com.bsworld.springboot.start.dao.entity.TPermission;

import java.util.List;

public interface TPermissionService {
    List<TPermission> queryTPermissionByRoleIds(List<Integer> roleIds);
}
