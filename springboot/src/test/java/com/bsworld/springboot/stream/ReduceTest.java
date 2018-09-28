package com.bsworld.springboot.stream;
/*
*author: xieziyang
*date: 2018/8/29
*time: 16:31
*description:
*/

import com.bsworld.springboot.basic.MyBean;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ReduceTest {
    @Test
    public void run1() {
        List<MyBean> list = new ArrayList<>();
        for (long i = 1; i < 10; i++) {

            list.add(new MyBean(String.valueOf((char) i), i));
        }
        Optional<Long> reduce = list.stream().map(m -> m.getAge()).reduce((m, n) -> m + n);
        if (reduce.isPresent()) {
            Long aLong = reduce.get();
            System.out.println(aLong);
        }
    }

    @Test
    public void run2() {
        ConcurrentHashMap<String, MyBean> collect = new ConcurrentHashMap<>();
        MyBean myBean0 = new MyBean("a", "10", 22l);
        MyBean myBean1 = new MyBean("b", "10", 22l);
        MyBean myBean2 = new MyBean("c", "10", 22l);
        MyBean myBean3 = new MyBean("d", "11", 22l);
        MyBean myBean4 = new MyBean("e", "11", 22l);
        ArrayList<MyBean> list = new ArrayList<>();
        list.add(myBean0);
        list.add(myBean1);
        list.add(myBean2);
        list.add(myBean3);
        list.add(myBean4);
        list.stream().forEach(m ->
                list.stream().forEach(n -> {
                    if (m.getAge() == n.getAge() && m.getPassword().equals(n.getPassword())) {
                        collect.putIfAbsent(m.getAge() + m.getPassword(), m);
                    }
                })
        );
        System.out.println(collect.size());
    }

    @Test
    public void run3() {
        Map<String, String> treeMap = new LinkedHashMap<>();
        treeMap.put("merName", "商户名称");
        treeMap.put("withFlowNo", "商户提现单号");
        treeMap.put("channelName", "提现通道");
        treeMap.put("currencyCode", "提现币种");
        treeMap.put("amountTmplate", "提现金额");
        treeMap.put("withTime", "提现创建时间");
        treeMap.put("auditStatusDown", "审核状态");
        treeMap.put("auditor", "审核人");
        treeMap.put("auditTime", "审核时间");
        treeMap.keySet().forEach(m -> System.out.println(m));
    }
}
