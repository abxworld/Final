package com.bsworld.springboot.start.DataStruAlgorithm.bean;
/*
*author: xieziyang
*date: 2018/10/20
*time: 11:35
*description:
*/

public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Interval{");
        sb.append("start=").append(start);
        sb.append(", end=").append(end);
        sb.append('}');
        return sb.toString();
    }
}
