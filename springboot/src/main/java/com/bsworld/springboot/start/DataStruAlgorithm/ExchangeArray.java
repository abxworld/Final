package com.bsworld.springboot.start.DataStruAlgorithm;
/*
*author: xieziyang
*date: 2018/10/21
*time: 16:03
*description:
*/

public class ExchangeArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
    }
    public static void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        int length = nums.length;
        for(int i=0; i<nums.length; i++ ){
            int pos = i + (k % length);
            if(pos >= length) {
                result[pos-length] = nums[i];
            }else{
                result[pos] = nums[i];
            }
        }
        nums = result;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
