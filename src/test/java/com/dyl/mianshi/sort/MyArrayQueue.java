package com.dyl.mianshi.sort;

public class MyArrayQueue {

    private String[] items ;
    private int n;
    private int head;
    private int tail;

    public MyArrayQueue(int n){
        items = new String[n];
        this.n = n;
    }

    public boolean enqueue(String str){
        if(tail == n){
            if(head == 0){
                return false;
            }
            for(int i = head;i<tail;i++){
                items[i-n] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail++] = str;
        return true;
    }

    public String dequeue(){
        if(head == tail){
            return null;
        }
        return items[head++] ;
    }
}
