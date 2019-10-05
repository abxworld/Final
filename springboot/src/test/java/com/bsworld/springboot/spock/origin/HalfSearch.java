package com.bsworld.springboot.spock.origin;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-10-05 16:46
 * description:
 */
public class HalfSearch {
    public static int search(int[] arr, int key) {

        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            }
            else if (arr[mid] == key) {
                return mid;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
