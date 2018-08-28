package com.bsworld.springboot.start.service.impl;
/*
*author: xieziyang
*date: 2018/7/30
*time: 18:22
*description:
*/

import com.bsworld.springboot.start.dao.entity.TUserRole;
import com.bsworld.springboot.start.dao.entity.TUserRoleExample;
import com.bsworld.springboot.start.dao.mapper.TUserRoleMapper;
import com.bsworld.springboot.start.service.TUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TUserRoleServiceImpl implements TUserRoleService {
    @Autowired
    TUserRoleMapper tUserRoleMapper;
    @Override
    public List<TUserRole> queryRoleByUserId(Integer userId) {
        TUserRoleExample example = new TUserRoleExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<TUserRole> tUserRoles = tUserRoleMapper.selectByExample(example);
        return tUserRoles;
    }
}
