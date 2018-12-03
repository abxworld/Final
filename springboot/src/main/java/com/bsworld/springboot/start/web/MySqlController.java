package com.bsworld.springboot.start.web;

import com.alibaba.fastjson.JSON;
import com.bsworld.springboot.start.dao.entity.TUser;
import com.bsworld.springboot.start.dao.entity.TUserExample;
import com.bsworld.springboot.start.dao.mapper.TUserMapper;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * author: xieziyang
 * date: 2018/7/23
 * time: 16:28
 * description:
 */


@RequestMapping("/")
@RestController
public class MySqlController implements Runnable{
    @Autowired
    TUserMapper userMapper;

    @PostMapping(value = "/mysql")
    public void test() {
        try {
            TUser tUser = getUser();
            Class<? extends TUser> aClass = tUser.getClass();
            TUserExample example = new TUserExample();
            TUserExample.Criteria criteria = example.createCriteria();
            Class<? extends TUserExample.Criteria> criteriaClass = criteria.getClass();
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                String name = field.getName();
                String toName = "";
                Method method = null;
                if (name.length() > 1) {
                    toName = name.substring(0, 1).toUpperCase() + name.substring(1);
                    method = aClass.getMethod("get" + toName);
                } else {
                    toName = name.substring(0, 1).toUpperCase();
                    method = aClass.getMethod("get" + toName);
                }
                Object invoke = method.invoke(tUser);
                if (invoke instanceof String) {
                    String value = (String) invoke;
                    if (!StringUtils.isNullOrEmpty(value)) {

                        Method criteriaClassMethod = criteriaClass.getSuperclass().getMethod("and" + toName + "EqualTo");
                        criteriaClassMethod.invoke(criteria);
                    }
                } else {
                    if (invoke != null) {
                        Method criteriaClassMethod = criteriaClass.getSuperclass().getMethod("and" + toName + "EqualTo");
                        criteriaClassMethod.invoke(criteria);
                    }
                }
            }
            List<TUser> tUsers = userMapper.selectByExample(example);
            System.out.println(JSON.toJSONString(tUsers));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/json")
    public void test(@RequestBody HashMap jsonObject) {
        System.out.println(JSON.toJSONString(jsonObject));
    }

    TUser getUser() {
        TUser tUser = new TUser();
        tUser.setUsername("tom");
        return tUser;
    }


    @Override
    public void run() {

    }
}
