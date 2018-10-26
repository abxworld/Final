package com.bsworld.springboot.start.DataStruAlgorithm;
/*
*author: xieziyang
*date: 2018/10/20
*time: 11:34
*description:
*/

import com.bsworld.springboot.start.DataStruAlgorithm.bean.Interval;

import java.util.ArrayList;
import java.util.List;

public class MergeArray {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(6, 9));
        intervals.add(new Interval(7, 8));
        intervals.add(new Interval(7, 8));
        intervals.add(new Interval(7, 19));
        List<Interval> merge = merge(intervals);
        System.out.println(merge.size());
        System.out.println(merge);
    }
    private static List<Interval> merge(List<Interval> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) {
                    continue;
                }
                Interval ii = list.get(i);
                Interval jj = list.get(j);
                boolean flag0 = (ii.start >= jj.start && ii.end <= jj.end );
                boolean flag1 = (ii.start <= jj.start && ii.end >=jj.start);
                if (flag0) {
                    list.remove(ii);
                    merge(list);
                } else if (flag1) {
                    list.remove(ii);
                    list.remove(jj);
                    list.add(new Interval(ii.start, Integer.max(ii.end, jj.end)));
                    merge(list);
                }
            }
        }
        return list;
    }
}

