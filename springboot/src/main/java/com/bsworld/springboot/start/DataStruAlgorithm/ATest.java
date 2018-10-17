package com.bsworld.springboot.start.DataStruAlgorithm;
/*
*author: xieziyang
*date: 2018/10/15
*time: 13:50
*description:
*/

import java.util.ArrayList;
import java.util.List;

public class ATest {

    public static void main(String[] args) {
        cal();
    }

    public static TreeNode<Integer> cal() {
        Integer[] values = {4, 5, 6, 7, 1, 2, 3,};
        TreeNode<Integer> node = new TreeNode<>(null);
        for (Integer value : values) {
            sort(node, new TreeNode(value));
        }
        List<Integer> list = new ArrayList<>();
        MidSort(node, list);
        System.out.println(list);
        return node;
    }

    private static void sort(TreeNode<Integer> node, TreeNode<Integer> newNode) {
        if (node.val == null) {
            node.val = newNode.val;
        }
        if (newNode.val < node.val) {
            if (node.getLeft() != null) {
                sort(node.getLeft(), newNode);
            } else {
                node.setLeft(new TreeNode<>(newNode.val));
            }
        } else if (newNode.val > node.val) {
            if (node.getRight() != null) {
                sort(node.getRight(), newNode);
            } else {
                node.setRight(new TreeNode<>(newNode.val));
            }
        } else {
           // System.out.println("root, val: " + node.val);
        }
    }

    private static void preSort(TreeNode<Integer> node) {
        if (node == null) {
            return;
        }
        Integer val = node.val;
        System.out.println(val);
        preSort(node.getLeft());
        preSort(node.getRight());
    }

    private static void MidSort(TreeNode<Integer> node, List<Integer> list) {
        if (node == null) {
            return;
        }
        MidSort(node.getLeft(), list);
        list.add(node.val);
        MidSort(node.getRight(),list);
    }
}
