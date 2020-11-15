package com.dyl.thread;

import com.google.common.collect.Lists;
import javafx.concurrent.Task;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABCThread  {

    private static int count = 0 ;

    public static void main(String[] args) {
        solution1();
    }

    private static void solution2() {
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


    public static void solution1(){
        AtomicInteger atomicInteger = new AtomicInteger(0);
        new Thread(() ->{
            while (true){
                if(atomicInteger.get()%3 == 0){
                    System.out.println("A");
                    atomicInteger.getAndIncrement();
                }
            }
        }).start();

        new Thread(() ->{
            while (true){
                if(atomicInteger.get()%3 == 1){
                    System.out.println("B");
                    atomicInteger.getAndIncrement();
                }
            }
        }).start();

        new Thread(() ->{
            while (true){
                if(atomicInteger.get()%3 == 2){
                    System.out.println("C");
                    atomicInteger.getAndIncrement();
                }
            }
        }).start();
    }



}
