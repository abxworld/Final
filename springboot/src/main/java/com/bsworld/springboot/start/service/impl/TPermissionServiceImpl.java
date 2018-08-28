package com.bsworld.springboot.start.service.impl;
/*
*author: xieziyang
*date: 2018/7/30
*time: 19:47
*description:
*/

import com.bsworld.springboot.start.dao.entity.TPermission;
import com.bsworld.springboot.start.dao.entity.TPermissionExample;
import com.bsworld.springboot.start.dao.mapper.TPermissionMapper;
import com.bsworld.springboot.start.service.TPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TPermissionServiceImpl implements TPermissionService {
    @Autowired
    TPermissionMapper tPermissionMapper;

    @Override
    public List<TPermission> queryTPermissionByRoleIds(List<Integer> roleIds) {
        TPermissionExample example = new TPermissionExample();
        example.createCriteria().andRoleIdIn(roleIds);
        return tPermissionMapper.selectByExample(example);
    }
}
