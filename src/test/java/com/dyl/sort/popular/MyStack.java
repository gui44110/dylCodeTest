package com.dyl.sort.popular;

public class MyStack {

    private String[] items;

    private int count;

    private int n;

    public MyStack(int n){
        items = new String[n];
        this.n = n;
        this.count = 0;
    }

    public boolean push(String item){
        if(count == n){
            return false;
        }
        items[count++] = item;
        return true;
    }

    public String pop(){
        if(count == 0){
            return null;
        }
        return items[--count];
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(5);
        myStack.push("1");
        myStack.push("2");
        myStack.push("3");
        myStack.push("4");
        myStack.push("5");
        myStack.push("6");
        System.out.println(myStack.pop() +">"+myStack.pop() +">"+myStack.pop() +">"+myStack.pop() +">"+myStack.pop() +">"+myStack.pop() +">" );


    }
}
