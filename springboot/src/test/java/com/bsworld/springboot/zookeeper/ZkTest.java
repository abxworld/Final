package com.bsworld.springboot.zookeeper;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.util.List;
/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-09-25 17:10
 * description:
 */
public class ZkTest {
    List<Runnable> listeners = Lists.newArrayList(new Runnable() {
        @Override
        public void run() {
            System.out.println();
        }
    });

    public static void main(String[] args) {
    }

}
