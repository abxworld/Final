package com.bsworld.springboot.start.web;

import com.alibaba.fastjson.JSON;
import com.bsworld.springboot.start.dao.entity.TUser;
import com.bsworld.springboot.start.dao.entity.TUserExample;
import com.bsworld.springboot.start.dao.mapper.TUserMapper;
import com.mysql.cj.util.StringUtils;
import org.apache.commons.jexl3.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
*author: xieziyang
*date: 2018/8/7
*time: 11:46
*description:
*/
@RequestMapping("/user")
@Controller
public class UserController implements InitializingBean{
    @Autowired
    TUserMapper tUserMapper;

    @PostMapping(value = "/get")
    public void run() {
        TUser user = getUser();
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        String condition = condition(criteria, user);
        JexlContext context = new MapContext();
        context.set("criteria", criteria);
        context.set("user", user);
        StringUtils utils = new StringUtils();
        context.set("StringUtils", utils);
        JexlEngine engine = new JexlBuilder().create();
        JexlScript script = engine.createScript(condition);
        script.execute(context);
        List<TUser> tUsers = tUserMapper.selectByExample(example);
        System.out.println(JSON.toJSONString(tUsers));
    }

    public TUser getUser() {
        TUser user = new TUser();
        user.setUsername("tom");
        user.setPassword("123456");
        return user;
    }

    public String condition(TUserExample.Criteria criteria, TUser user) {
        String condition = " if (!StringUtils.isNullOrEmpty(user.getUsername())) {\n" +
                "            criteria.andUsernameEqualTo(user.getUsername());\n" +
                "        }\n" +
                "        if (!StringUtils.isNullOrEmpty(user.getPassword())) {\n" +
                "            criteria.andPasswordEqualTo(user.getPassword());\n" +
                "        }";

        return condition;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("start user controller");
    }
}
