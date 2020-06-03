package com.bsworld.springboot.DataAlgo;

import com.alibaba.fastjson.JSON;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-05-15 16:16
 * description:
 */
public class ListReverseTest {
    public static void main(String[] args) {
        ListReverseTest test = new ListReverseTest();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = test.reverseList(head);
        System.out.println(JSON.toJSONString(listNode));

    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (true) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            if (next == null) {
                return cur;
            }
            cur = next;
        }
    }

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
}
