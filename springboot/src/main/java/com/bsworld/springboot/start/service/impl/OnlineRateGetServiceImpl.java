package com.bsworld.springboot.start.service.impl;
/*
*author: xieziyang
*date: 2018/8/1
*time: 16:02
*description:
*/

import com.alibaba.fastjson.JSON;
import com.bsworld.springboot.start.dao.entity.TUser;
import com.bsworld.springboot.start.dao.mapper.TUserMapper;
import com.bsworld.springboot.start.service.OnlineRateGetService;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OnlineRateGetServiceImpl implements OnlineRateGetService, InitializingBean {
    @Autowired
    TUserMapper tUserMapper;
    private AtomicInteger count = new AtomicInteger();

    @Override
    public void afterPropertiesSet() throws Exception {
        queryOnlineRateAndInsert();
    }


    @Override
    public void queryOnlineRateAndInsert() {
        try {
            System.out.println("task start" + count.get());
            ScheduledExecutorService scheduledService = new ScheduledThreadPoolExecutor(5);
            RateQuery<String> query = new RateQuery<>();
       //     ScheduledFuture future = scheduledService.scheduleWithFixedDelay(query, 0, 3, TimeUnit.SECONDS);
           /* if (future != null) {
                Object o = future.get();
                System.out.println(JSON.toJSONString(o));
            }*/
        } catch (Throwable t) {
            // t.printStackTrace();
        }
        System.out.println("task end");
    }


    private class RateQuery<T> implements Runnable {
        @Override
        public void run() {
            try {
                TUser data = getData();
                System.out.println(JSON.toJSONString(data));
                tUserMapper.insertSelective(data);
            } catch (Throwable t) {
                System.out.println(t);
            }
        }
    }

    public TUser getData() {
        TUser tUser = new TUser();
        tUser.setUsername("testName" + count.getAndIncrement());
        tUser.setPassword("testPass" + count.get());
        if (count.get() > 3) {
            throw new IllegalStateException("invoker failed");
        }
        return tUser;
    }
}
