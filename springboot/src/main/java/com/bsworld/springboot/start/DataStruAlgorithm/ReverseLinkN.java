package com.bsworld.springboot.start.DataStruAlgorithm;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-05-25 20:22
 * description:
 */
public class ReverseLinkN {
    private static class TreeNode{
        private int val;
        private TreeNode next;

        public TreeNode(int val, TreeNode next) {
            this.val = val;
            this.next = next;
        }

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        int n = 3;
        TreeNode root = produceNode();
        TreeNode zero = new TreeNode(-1, root);
        TreeNode a = root;
        for (int i = 0; i < n; i++) {
            a = a.next;
        }
        TreeNode b = zero;
        while (a.next != null) {
            a = a.next;
            b = b.next;
        }
        TreeNode b1 = b.next;
        TreeNode b2 = b.next.next;
        b.next = b2;
        b1.next = null;
        System.out.println(root);
    }




    private static TreeNode produceNode() {
        TreeNode node = new TreeNode(0);
        TreeNode root = node;
        for (int i = 0; i < 9; i++) {
            node.next = new TreeNode(i + 1);
            node = node.next;
        }
        return root;
    }
}
