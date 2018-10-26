package com.bsworld.springboot.start.DataStruAlgorithm;
/*
*author: xieziyang
*date: 2018/10/20
*time: 15:45
*description:
*/

import java.util.ArrayList;
import java.util.List;

public class ArraySame {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] intersect = intersect(nums1, nums2);
        for (int i = 0; i < intersect.length; i++) {
            System.out.print(intersect[i]);
        }
    }

    /*
    * 求出数组的交集
    * */
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        Integer[] m = new Integer[nums2.length];
        for (int i = 0; i < m.length; i++) {
            m[i] = new Integer(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[j] == null) {
                    continue;
                }
                if (nums1[i] == m[j].intValue()) {
                    list.add(nums1[i]);
                    m[j] = null;
                    break;
                }
            }
        }
        int[] result = new int[list.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
