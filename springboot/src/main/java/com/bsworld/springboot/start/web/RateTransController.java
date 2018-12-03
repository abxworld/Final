package com.bsworld.springboot.start.web;
/*
 *author: xieziyang
 *date: 2018/9/14 
 *time: 17:40
 *description:
 */

import com.bsworld.springboot.start.dao.entity.TRateTransform;
import com.bsworld.springboot.start.dao.entity.TRateTransformExample;
import com.bsworld.springboot.start.dao.mapper.TRateTransformMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequestMapping("/rate")
@Controller
public class RateTransController implements Runnable {
    @Autowired
    TRateTransformMapper tRateTransformMapper;


    @PostMapping("/insert")
    public void insert() {
        TRateTransform rateTransform = tRateTransformMapper.selectByPrimaryKey(370L);
        long start = System.currentTimeMillis();
        System.out.println("start, time: " + start);
        for (int i = 0; i < 100000; i++) {
            rateTransform.setId(null);
            rateTransform.setCreateTime(new Date());
            tRateTransformMapper.insertSelective(rateTransform);
        }
        long end = System.currentTimeMillis();
        System.out.println("end, time:" + end);
        System.out.println("total time: " + (end - start) / 1000);
    }

    @PostMapping("/query")
    public void query() {
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        TRateTransformExample example = new TRateTransformExample();
        long start = System.currentTimeMillis();
        System.out.println("start, time: " + start);
        List<TRateTransform> rateTransforms = tRateTransformMapper.selectByExample(example);
        long end = System.currentTimeMillis();
        System.out.println("end, time:" + end);
        System.out.println("total time: " + (end - start) / 1000);
    }

    @PostMapping("/threadquery")
    public void queryThread() {
        System.out.println("thread query!!!!!");
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        for (int i = 400; i < 130000; i = i + 10000) {
            fixedThreadPool.execute(new Rate(i, i + 10000));
        }
    }

    @Override
    public void run() {

    }



    private class Rate implements Runnable {
        private long min;
        private long max;

        public Rate(long min, long max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public void run() {
            TRateTransformExample example = new TRateTransformExample();
            example.createCriteria().andIdBetween(min, max);
            long start = System.currentTimeMillis();
            System.out.println("start, time: " + start);
            List<TRateTransform> rateTransforms = tRateTransformMapper.selectByExample(example);
            long end = System.currentTimeMillis();
            System.out.println("end, time:" + end);
            System.out.println("Thread,name:" + Thread.currentThread().getName() + ", total time: " + (end - start) / 1000);
        }
    }

}
