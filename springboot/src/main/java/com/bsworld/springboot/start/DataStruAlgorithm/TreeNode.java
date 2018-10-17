package com.bsworld.springboot.start.DataStruAlgorithm;
/*
*author: xieziyang
*date: 2018/10/15
*time: 13:54
*description:
*/

public class TreeNode<Integer> {
    public TreeNode<Integer> left;
    public TreeNode<Integer> right;
    public Integer val;

    public TreeNode(Integer val) {
        this.val = val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public TreeNode<Integer> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<Integer> left) {
        this.left = left;
    }

    public TreeNode<Integer> getRight() {
        return right;
    }

    public void setRight(TreeNode<Integer> right) {
        this.right = right;
    }

    public Integer getVal() {
        return val;
    }
}
