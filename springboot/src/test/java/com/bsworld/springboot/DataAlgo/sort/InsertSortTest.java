package com.bsworld.springboot.DataAlgo.sort;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-05-13 09:59
 * description:
 */
public class InsertSortTest {

    @Test
    public void sort() {
        int[] arr = {1,8,6,5,12,10,0};
        sortCore(arr);
        System.out.println(JSON.toJSONString(arr));
    }

    private void sortCore(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int p = arr[i];
            int lastLoc = -1;
            for (int j = i; j > 0  ; j--) {
                if (p < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    lastLoc = j-1;
                } else {
                    break;
                }
            }
            if (lastLoc >= 0) {
                arr[lastLoc] = p;
            }
        }
    }

    private void leftDfs(int[] arr) {



    }
}
