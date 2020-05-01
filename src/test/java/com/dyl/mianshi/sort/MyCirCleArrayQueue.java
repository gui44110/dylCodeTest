package com.dyl.mianshi.sort;

public class MyCirCleArrayQueue {

    private String[] items;

    private int n;

    private int head;

    private int tail;

    public MyCirCleArrayQueue(int  n){
        items = new String[n];
        this.n = n;
    }

    public boolean enqueue(String item){
        if((tail+1)%n == head){
            return false;
        }
        items[tail] = item;
        tail = (tail+1)%n;
        return true;
    }

    public String dequeue(){
        if(tail == head){
            return null;
        }
        String result = items[head] ;
        head = (head+1)%n;
        return result;
    }
}
