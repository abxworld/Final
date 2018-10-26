package com.bsworld.springboot.start.web;
/*
*author: xieziyang
*date: 2018/7/20
*time: 15:02
*description:
*/

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static java.lang.Integer.max;

public class StringTest {
    @Test
    public void run1() {
        String a = "12345678";
        String substring = a.substring(4, 8);
        System.out.println(substring);
    }

    @Test
    public void run2() {
        List<Object> list = Arrays.asList("hello", "world");
        HashMap<String, Object> hashMap = Maps.newHashMap();
        HashMap<String, String> aMap = Maps.newHashMap();
        hashMap.put("other", list);
        System.out.println(JSON.toJSONString(JSON.toJSONString(hashMap)));
        //System.out.println(JSON.toJSONString(aMap));
    }

    @Test
    public void run3() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\a.d");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        Hello hello = new Hello();
        hello.setAge(10);
        hello.setName("world");
        hello.setSex("0");
        hello.setDate(new Date());
        oos.writeObject(hello);
    }

    @Test
    public void run4() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("D:\\a.d");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Hello object = (Hello) ois.readObject();
        System.out.println(JSON.toJSONString(object));
    }

    @Test
    public void run5() {
        Ordering<Comparable> natural = Ordering.natural();
        LocalDate date1 = LocalDate.of(2018, 1, 24);
        LocalDate date2 = LocalDate.of(2018, 1, 25);
        LocalDate max = natural.max(date1, date2);
        // System.out.println(max);
        Integer min = natural.min(11, 2);
        //  System.out.println(min);
        String compare = natural.min("Aa", "AA");
        // System.out.println(compare);

        List<Integer> list = Arrays.asList(1, 2, 3, 23, 12, 56, 12);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 23, 12, 100, 12);
        Integer min1 = natural.max(natural.max(list), natural.max(list2));
        System.out.println(min1);
    }

    public static void main(String[] args) {
        String a = "0.1235";
        boolean numeric = isNumeric(a);
        System.out.println(numeric);
    }

    public static boolean isNumeric(String str) {
        String trim = str.trim();
        for (int i = 0; i < trim.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void run6() {
        String a = "hello world hehvherybody";
        String max = getMax(a);
        System.out.println(max);
    }

    private String getMax(String a) {
        char[] chars = a.toCharArray();
        int max = 0;
        int charAt = 0;
        for (int i = 0; i < chars.length; i++) {
            int atNum = 0;
            for (char c : chars) {
                if (chars[i] == c) {
                    atNum++;
                }
            }
            if (atNum > max) {
                max = atNum;
                charAt = i;
            }
        }
        String s = new String(new char[]{chars[charAt]});
        return s;
    }

    @Test
    public void run7() {
        System.out.println("result: " + outPut());
    }

    private int outPut() {
        int a = 0;
        try {
            a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
        }
        return a;
    }

    @Test
    public void run8() {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(a);
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int j = 0; j < nums.length; j++) {
            int sum = 0;
            for (int i = j; i < nums.length; i++) {
                sum += nums[i];
                if (sum > result) {
                    result = sum;
                }
            }
        }
        return result;
    }


    @Test
    public void run9() {
        int[] a = {2,5, 0,0};
        boolean b = canJumpTanXin(a);
        System.out.println(b);
    }
    public static boolean canJumpDP(int [] A) {
        if (A.length == 1) return true;
        int [] dp = new int[A.length];
        dp[0] = A[0];
        for (int i = 1; i < dp.length; ++i) {
            if (dp[i-1] >= i)
                dp[i] = max(A[i]+i, dp[i-1]);
            else
                dp[i] = 0;
        }
        return dp[dp.length-1] >= A.length-1;
    }
    public boolean canJump(int[] nums) {
        int pos = 0;
        while(true){
            if(pos >= nums.length){
                return false;
            }
            int prepos =pos;
            pos += nums[pos];

            if(nums.length == 1 || pos >= nums.length - 1){
                return true;
            }
            if(pos < nums.length && prepos == pos){
                return false;
            }
        }
    }

    public boolean canJumpTanXin(int[] A) {
        int currMaxStep = A[0];  //当前能够跳跃的最大步数
        int step = 0;
        for (int i = 1; i < A.length; ++i) {
            if (i > currMaxStep) return false;
            currMaxStep = max(i+A[i], currMaxStep);
            if (currMaxStep >= A.length-1) return true;
        }
        return currMaxStep >= A.length-1;
    }
}
