package com.bsworld.springboot.stream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2018-12-27 15:15
 * description:
 */
public class EventMain {
    public static void main(String[] args) {
        List<EventInfo> events = Lists.newArrayList();
        DateTime dt = new DateTime();
        for (int i = 0; i < 100; i++) {
            Date date = dt.plusHours(i).toDate();
            EventInfo eventInfo = new EventInfo(Long.valueOf(i) + 1,date, "a" + i, i % 2);
            events.add(eventInfo);
        }
        Collections.shuffle(events);
        LinkedHashMap<Integer, Long> transferMap = Maps.newLinkedHashMap();
        events.stream()
                .filter(entity -> entity != null)
                .sorted(Comparator.comparing(EventInfo::getCreateTime))
                .forEachOrdered(eventInfo -> transferMap.put(eventInfo.getLocation(), eventInfo.getEventId()));
        System.out.println(JSON.toJSONString(transferMap));
    }
}
