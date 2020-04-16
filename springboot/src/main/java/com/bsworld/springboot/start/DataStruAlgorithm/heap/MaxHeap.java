package com.bsworld.springboot.start.DataStruAlgorithm.heap;

import com.bsworld.springboot.start.web.MySqlTestBean;
import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-03-30 10:28
 * description:
 */
public class MaxHeap {

    private int[] bucket = new int[100];

    private int currentSize = -1;

    public void filterUp(int a) {

        int nowSize = currentSize + 1;

        bucket[nowSize] = a;

        int parentSize;
        while ((parentSize = (nowSize - 1) / 2) >= 0) {
            if (a > bucket[parentSize]) {

                bucket[nowSize] = bucket[parentSize];

                bucket[parentSize] = a;
                nowSize = parentSize;
            } else {
                break;
            }
        }
        currentSize ++;
    }

    public int[] getBucket() {
        return bucket;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = Lists.newArrayList(1, null, 3);
        List<Long> transform = Lists.transform(list, m -> {
            System.out.println("计算开始,m:" + m);
            return new BigDecimal(m).multiply(new BigDecimal(100)).longValue();
        });
        System.out.println(transform.getClass());
        System.out.println(transform);
    }
}
