package com.dyl.mianshi.sort;

public class MyLinkedQueue {

    Node head = null;

    Node tail = null;

    public boolean enqueue(String value){
        Node newNode = new Node(value);
        if(tail == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = tail.next;
        }
        return true;
    }

    public String dequeue(){
        if(head == null){
            return null;
        }
        String result = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return result;
    }


    class Node{

        public String value;
        public Node next;

        public Node(String value){
            this.value = value;
        }
    }
}
