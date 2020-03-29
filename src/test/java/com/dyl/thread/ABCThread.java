package com.dyl.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABCThread  {

    private static int count = 0 ;

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();

        Thread A = new Thread(() -> {
            while(count<29) {
                lock.lock();
                if(count%3==0){
                    System.out.println("A");
                    count++;
                }

                lock.unlock();
            }
        });

        Thread B = new Thread(new Runnable() {
            public void run() {
                while(count<30) {
                    lock.lock();
                    if(count%3==1){
                        System.out.println("B");
                        count++;
                    }

                    lock.unlock();
                }
            }
        });

        Thread C = new Thread(new Runnable() {
            public void run() {
                while(count<30) {
                    lock.lock();
                    if(count%3==2){
                        System.out.println("C");
                        count++;
                    }

                    lock.unlock();
                }
            }
        });

        A.start();
        B.start();
        C.start();
    }

}
