package com.dyl.pcModel;

public class Test {

    public static void main(String[] args) {
        Resource resource = new Resource(5);

        Thread p1 = new Thread(new Producer(resource));

        Thread p2 = new Thread(new Producer(resource));

        Thread c1 = new Thread(new Consumer(resource));

        p1.start();


        p2.start();
        c1.start();
    }
}
