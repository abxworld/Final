package com.bsworld.springboot.DataAlgo.model;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-08-15 12:06
 * description:
 */
public class Node {
    private Integer val;
    private Node nextNode;

    public Node(Integer val) {
        this.val = val;
    }

    public Node(Integer val, Node nextNode) {
        this.val = val;
        this.nextNode = nextNode;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", nextNode=" + nextNode +
                '}';
    }
}
