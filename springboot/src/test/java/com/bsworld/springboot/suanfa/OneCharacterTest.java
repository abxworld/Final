package com.bsworld.springboot.suanfa;


class MyLinkedList {

    /** Initialize your data structure here. */
    Node head = null;
    public MyLinkedList() {
        head = new Node();
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0) {
            int length = getLength();
            index = length  + index;
        }
            Node next = head.getNext();
            int i = 0;
            while(true){
                if(next != null){
                    Node ns =  next.getNext();
                    if(i == index){
                        return next.getVal();
                    }else if (ns == null){
                        return -1;
                    }else{
                        next = ns;
                    }
                }else{
                    return -1;
                }
                i ++;
            }
    }

    public Node getNode(int index) {
            if(index < 0) {
                int length = getLength();
                index = length  + index;
        }
        if(index >= 0){
            Node next = head.getNext();
            int i=0;
            while(true){
                if(next != null){
                    Node ns =  next.getNext();
                    if(i == index){
                        return next;
                    }else if (ns == null){
                        return null;
                    }else{
                        next = ns;
                    }
                }else{
                    return null;
                }
                i ++;
            }
        }else{
            return null;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node preZ = head.getNext();
        Node nowZ = new Node(val,preZ);
        head.setNext(nowZ);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node next = head.getNext();
        while(true) {
            if(next != null){
                Node ns = next.getNext();
                if(ns == null){
                    Node tail = new Node(val,null);
                    next.setNext(tail);
                    break;
                }else{
                    next = ns;
                }
            }else{
                Node tail = new Node(val,null);
                head.setNext(tail);
            }
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node next = head.getNext();
        if(index < 0) {
            int length = getLength();
            index = length  + index + 1;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }
        Node pre = getNode(index -1);
        if(pre == null){
            return;
        }
        Node np = pre.getNext();
        Node now = new Node(val, np);
        pre.setNext(now);
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index == 0){
            Node node = getNode(0);
            if(node == null){
                return;
            }
            Node next =  node.getNext();
            head.setNext(next);
        }
        if(index < 0) {
            int length = getLength();
            index = length  + index + 1;
        }
        Node pre = getNode(index -1);
        if(pre == null){
            return;
        }
        Node np = pre.getNext();
        if(np == null){
            return;
        }
        Node npn =  np.getNext();
        pre.setNext(npn);
    }

    public int getLength(){
        int i = 0;
        Node next = head.getNext();
        while(next != null) {
            i++;
            next = next.getNext();
        }
        return i;
    }



    static class Node{
        Integer val;
        Node next;
        public Node(){

        }
        public Node(Integer val, Node next){
            this.val = val;
            this.next = next;
        }
        public void setVal(Integer val){
            this.val = val;
        }
        public Integer getVal(){
            return val;
        }
        public void setNext(Node next){
            this.next = next;
        }
        public Node getNext(){
            return next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtIndex(-1, 0);
        int i = list.get(0);
        System.out.println(i);
    }
}

