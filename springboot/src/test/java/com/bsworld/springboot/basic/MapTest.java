package com.bsworld.springboot.basic;
/*
*author: xieziyang
*date: 2018/8/17
*time: 16:55
*description:
*/

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.boot.test.json.JsonContent;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {
//        HashMap<String, String> hashMap = new HashMap();
//        hashMap.put("a", "a");
//        hashMap.put("c", "a");
//        hashMap.put("d", "a");
//        hashMap.put("e", "a");
//        hashMap.forEach((name, value) -> {
//            if (name.equals("c")) {
//                return;
//            }
//            System.out.println(name + value);
//        });
//        HashMap<Integer, MyBean> map = Maps.newHashMap();

//        MyBean myBean = map.get(0);
//        if (myBean == null) {
//            myBean = new MyBean();
//            myBean.setAge(100000l);
//            map.put(0, myBean);
//        }
//        System.out.println(JSON.toJSONString(map.get(0)));
//        String jsonStr = "{\"0\":{\"progressNo\":0},\"0\":{\"useCount\":1,\"progressNo\":0}}";
//        Map map = JSON.parseObject(jsonStr, Map.class);
//        System.out.println(map);
//        System.out.println(JSON.toJSONString(map));

//        Map<Integer, MyBean> map = Maps.newHashMap();
//        MyBean mybean = new MyBean("hello", 1000l);
//        map.put(0, mybean);
//        String jsonString = JSON.toJSONString(map);
//        System.out.println(jsonString);
//        Map<Integer,MyBean> mapStr = JSON.parseObject(jsonString, Map.class);
//        System.out.println(mapStr);
//        System.out.println(mapStr.get(0));


        UserBuyGoodsInfoPo po1 = new UserBuyGoodsInfoPo();
        po1.setUid(2435835953154l);
        po1.setNovelId(2328342990850l);
        po1.setGoodsId(20l);
        po1.setCreateTime(new Date().getTime());
        po1.setUpdateTime(new Date().getTime());
        po1.setBuyCount(3);
        po1.setProgressMap("{0:{\"progressNo\":0,\"useCount\":2}}");

        UserBuyGoodsInfoPo po3 = new UserBuyGoodsInfoPo();
        po3.setUid(2435835953154l);
        po3.setNovelId(2328342990850l);
        po3.setGoodsId(20l);
        po3.setCreateTime(new Date().getTime());
        po3.setUpdateTime(new Date().getTime());
        po3.setBuyCount(3);
        po3.setProgressMap("{0:{\"progressNo\":0,\"useCount\":2}}");

        UserBuyGoodsInfoPo po2 = new UserBuyGoodsInfoPo();
        po2.setUid(2435835953154l);
        po2.setNovelId(2328342990850l);
        po2.setGoodsId(20l);
        po2.setCreateTime(new Date().getTime());
        po2.setUpdateTime(new Date().getTime());
        po2.setBuyCount(3);
        po2.setProgressMap("{0:{\"progressNo\":0,\"useCount\":2}}");
        List<UserBuyGoodsInfoPo> list1 = Lists.newArrayList(po1, po2);
        List<UserBuyGoodsInfoPo> list2 = Lists.newArrayList(po1, po2);
        List<UserBuyGoodsInfoPo> list3 = Lists.newArrayList(po1, po2);
        List<List<UserBuyGoodsInfoPo>> lists = Lists.newArrayList(list1, list2,list3);
        List<UserBuyGoodsInfoPo> collect = lists.stream().flatMap(l -> l.stream()).distinct().collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect.size());
    }

    public static <K, V> Map<K, V> parseMap(String obj) {
        return JSON.parseObject(obj, new com.alibaba.fastjson.TypeReference<Map<K, V>>() {
        });
    }




}
