package com.bsworld.springboot.DataAlgo;

import com.bsworld.springboot.DataAlgo.model.Node;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-08-15 12:06
 * description:
 */
public class LinkFlip {

    public static void main(String[] args) {
        LinkFlip flip = new LinkFlip();
        Node node = flip.newNode(null, 0);
        System.out.println(node);
        Node flipNode = flip.flip(node);
        System.out.println(flipNode);
    }


    private Node flip(Node head) {
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            Node nextNode = cur.getNextNode();
            cur.setNextNode(pre);
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }

    private Node newNode(Node preNode, Integer val) {
        Node node = new Node(val);
        Node head = null;
        if (preNode != null) {
            preNode.setNextNode(node);
        } else {
            head = node;
        }
        if (val == 10) {
            return head;
        }
        newNode(node, val + 1);
        return head;
    }
}
