package com.bsworld.springboot.DataAlgo.sort;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-05-15 01:35
 * description:
 */
public class MaoPaoSort {
    //每次将最小的值放入数组的前面
    @Test
    public void run1() {
        int[] a = {10,9,8,12,7};
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (i == j) {
                    continue;
                }

                if (a[j] < a[i]){
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        System.out.println(JSON.toJSONString(a));
    }
}
