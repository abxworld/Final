package com.bsworld.springboot.start.DataStruAlgorithm;
/*
*author: xieziyang
*date: 2018/10/16
*time: 16:20
*description:
*/

public class FastSort {
    public static void main(String[] args) {
        int[] a = {12, 9, 13, 45, 7, 6, 4, 32};

    }

    private void getMiddle(int[] a, int low, int high) {
        int key = a[low];
        while (low < high) {
            while (low < high && a[high] > key) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] < key) {
                low++;
            }
            a[high] = a[low];
        }
    }
}
