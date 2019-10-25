package com.bsworld.springboot.start.util;

import java.util.Map;

/**
 * program: o2o-recommend
 * author: bsworld.xie
 * create: 2019-09-29 14:22
 * description:
 */
public class Pair<F, S> {

    F first;

    S second;

    public static <F, S> Pair<F, S> makePair(F first, S second) {

        return new Pair<F, S>(first, second);
    }

    public static <F, S> Pair<F, S> makePair(F first, Map<F, S> fsMap) {
        S second = fsMap.get(first);
        return makePair(first, second);
    }

    private Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }


    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
