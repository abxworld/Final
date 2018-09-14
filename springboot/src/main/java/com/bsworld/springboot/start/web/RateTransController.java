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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@RequestMapping("/rate")
@Controller
public class RateTransController {
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
        TRateTransformExample example = new TRateTransformExample();
        long start = System.currentTimeMillis();
        System.out.println("start, time: " + start);
        List<TRateTransform> rateTransforms = tRateTransformMapper.selectByExample(example);
        long end = System.currentTimeMillis();
        System.out.println("end, time:" + end);
        System.out.println("total time: " + (end - start) / 1000);
    }
}
