package com.bsworld.springboot.start.service.impl;
/*
*author: xieziyang
*date: 2018/7/30
*time: 18:04
*description:
*/

import com.bsworld.springboot.start.dao.entity.TUser;
import com.bsworld.springboot.start.dao.entity.TUserExample;
import com.bsworld.springboot.start.dao.mapper.TUserMapper;
import com.bsworld.springboot.start.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TUserServiceImpl implements TUserService {
    @Autowired
    TUserMapper tUserMapper;

    @Override
    public TUser queryTUserBuLoginName(String loginName) {
        TUserExample example = new TUserExample();
        example.createCriteria().andUsernameEqualTo(loginName);
        List<TUser> tUsers = tUserMapper.selectByExample(example);
        if (tUsers.isEmpty()) {
            return null;
        }
        return tUsers.get(0);
    }
}
