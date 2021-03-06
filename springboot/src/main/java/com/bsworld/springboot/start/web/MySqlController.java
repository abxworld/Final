package com.bsworld.springboot.start.web;

import com.alibaba.fastjson.JSON;
import com.bsworld.springboot.start.aop.Dlock.DLock;
import com.bsworld.springboot.start.dao.entity.TUser;
import com.bsworld.springboot.start.dao.entity.TUserExample;
import com.bsworld.springboot.start.dao.mapper.TUserMapper;
import com.bsworld.springboot.start.service.TUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

/**
 * author: xieziyang
 * date: 2018/7/23
 * time: 16:28
 * description:
 */


@RequestMapping("/mysql")
@RestController
public class MySqlController implements Runnable {
    @Autowired
    TUserMapper userMapper;
    @Autowired
    TUserService tUserService;

    @PostMapping(value = "/test")
    @ResponseBody
    @DLock(key = "'hello' + #bean.userName", expireTime = 100)
    public void test(MySqlTestBean bean) {
        tUserService.queryTUserBuLoginName("hello");
        TUserMapper springBean = HotDeployUtil.getSpringBean(TUserMapper.class);
        System.out.println("userMapper:" + userMapper + "       springBean:" + springBean + "  result:" + (springBean == userMapper));
        System.out.println("bean:" + JSON.toJSONString(bean));
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
                    if (StringUtils.isNotEmpty(value)) {

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



    @PostMapping(value = "request")
    public String request(Long uid , MySqlTestBean mySqlTestBean) {
        System.out.println("uid:" + uid);
        System.out.println("test start, reques" + JSON.toJSONString(mySqlTestBean));
        return "hello world";
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
