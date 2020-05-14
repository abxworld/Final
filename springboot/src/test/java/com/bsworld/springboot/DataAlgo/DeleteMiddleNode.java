package com.bsworld.springboot.DataAlgo;

import com.alibaba.fastjson.JSON;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-05-14 01:15
 * description:
 */
public class DeleteMiddleNode {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);
        node.next.next.next.next = new ListNode(10);
        node.next.next.next.next.next = new ListNode(11);
        node.next.next.next.next.next.next = new ListNode(13);
        DeleteMiddleNode d = new DeleteMiddleNode();
        d.deleteNode(node);
        System.out.println(JSON.toJSONString(node));
    }

    public void deleteNode(ListNode node) {
        if(node == null || node.next == null || node.next.next == null) {
            return;
        }
        ListNode first = node.next;
        ListNode second = node.next.next;
        ListNode lastStep = node;
        while(second != null && second.next != null && second.next.next != null){
            lastStep = first;
            first = first.next;
            if(second.next != null){
                second = second.next.next;
            }else{
                second = null;
            }
        }

        lastStep.next = first.next;
        first.next = null;
    }
}
