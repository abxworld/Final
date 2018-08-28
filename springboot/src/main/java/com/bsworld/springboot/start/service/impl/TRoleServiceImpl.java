package com.bsworld.springboot.start.service.impl;
/*
*author: xieziyang
*date: 2018/7/30
*time: 18:27
*description:
*/

import com.bsworld.springboot.start.dao.entity.TRole;
import com.bsworld.springboot.start.dao.entity.TRoleExample;
import com.bsworld.springboot.start.dao.mapper.TRoleMapper;
import com.bsworld.springboot.start.service.TRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TRoleServiceImpl implements TRoleService {
    @Autowired
    TRoleMapper tRoleMapper;

    @Override
    public List<TRole> queryTRoleByRoleIdList(List<Integer> roleIds) {
        TRoleExample example = new TRoleExample();
        example.createCriteria().andIdIn(roleIds);
        return tRoleMapper.selectByExample(example);
    }
}
