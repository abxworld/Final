package com.bsworld.springboot.DataAlgo.model;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-08-15 13:00
 * description:
 */
public class TwoNumberAdd {
    public static void main(String[] args) {
        int target = 9;
        int[] arr = {2,7,11,15};
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    num1 = arr[i];
                    num2 = arr[j];
                }
            }
        }
        System.out.println(num1);
        System.out.println(num2);
    }
}
