package com.bsworld.springboot.start.DataStruAlgorithm.heap;

import com.alibaba.fastjson.JSON;

import static org.junit.Assert.*;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-03-30 10:30
 * description:
 */
public class MaxHeapTest {
    public static void main(String[] args) {
        MaxHeap m = new MaxHeap();
        for (int i = 0; i < 100; i++) {
            m.filterUp(i);
        }
        int[] bucket = m.getBucket();
        int i = 0;
        int length = bucket.length;
        int size = 0;
        while (size < length - 1) {
            System.out.println(i);

        }
    }
}