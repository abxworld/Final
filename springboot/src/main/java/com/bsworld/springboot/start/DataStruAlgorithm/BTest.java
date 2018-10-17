package com.bsworld.springboot.start.DataStruAlgorithm;
/*
*author: xieziyang
*date: 2018/10/15
*time: 17:28
*description:
*/

public class BTest {
    public static void main(String[] args) {
        TreeNode<Integer> node0 = ATest.cal();
        TreeNode<Integer> node1 = ATest.cal();
        boolean sameTree = isSameTree(node0, node1);
        System.out.println(sameTree);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        boolean flag = sort(p, q);
        return flag;
    }

    private static boolean sort(TreeNode<Integer> p, TreeNode<Integer> q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p != null && q == null) || (p == null && q != null)) {
            return false;
        }
        boolean sort0 = sort(p.left, q.left);
        boolean sort1 = sort(p.right, q.right);
        if (sort0 == false || sort1 == false) {
            return false;
        }
        return true;
    }
}
