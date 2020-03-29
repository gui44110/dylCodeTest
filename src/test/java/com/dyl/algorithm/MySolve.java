package com.dyl.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author dongyuliang
 * @date 2019-07-10 11:59
 */
public class MySolve {



    class DoubleLinkedNode{

        int maxSize ;

        int size ;

        Node head;

        Node tail;
        public DoubleLinkedNode(int maxSize){
            this.maxSize = maxSize;
        }

        public void add(Node node){

        }

        public void delete(Node node){

        }

        boolean containsValue(int value){
            if(contain(value)){
                return true;
            }

            return false;
        }


        boolean contain(int value){
            Node current = head;
            while(current!=null){
                if(current.value == value){
                    return true;
                }
                current = current.next;
            }
            return false;
        }

    }

    class Node{
        Integer value;

        Node next;

        Node pre;
    }
}
