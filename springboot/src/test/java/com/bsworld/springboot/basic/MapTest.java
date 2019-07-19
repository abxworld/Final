package com.bsworld.springboot.basic;
/*
*author: xieziyang
*date: 2018/8/17
*time: 16:55
*description:
*/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.springframework.boot.test.json.JsonContent;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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


        UserBuyGoodsInfoPo po = new UserBuyGoodsInfoPo();
        po.setUid(2435835953154l);
        po.setNovelId(2328342990850l);
        po.setGoodsId(20l);
        po.setCreateTime(new Date().getTime());
        po.setUpdateTime(new Date().getTime());
        po.setBuyCount(3);
        po.setProgressMap("{0:{\"progressNo\":0,\"useCount\":2}}");
        String progressMap = po.getProgressMap();
        Map<Integer, UserProgressGoodsInfo> map = parseMap(progressMap);
        UserProgressGoodsInfo userProgressGoodsInfo = map.get(0);
        System.out.println(userProgressGoodsInfo);

    }

    public static <K, V> Map<K, V> parseMap(String obj) {
        return JSON.parseObject(obj, new com.alibaba.fastjson.TypeReference<Map<K, V>>() {
        });
    }
}
