package com.bsworld.springboot.jvm;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-06-15 17:43
 * description:
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.sumNums(2);
        System.out.println(i);
    }
    public int sumNums(int n) {
        add(n);
        return Holder.get();
    }

    public void add(int n ){
        if(n == 0){
            return;
        }
        int sum =  Holder.get() + n;
        Holder.set(sum);
        n--;
        add(n);
    }

    public static class Holder{
        private static int sum;

        public static void set(int sum){
            Holder.sum = sum;
        }
        public static int get(){
            return sum;
        }

    }
}

