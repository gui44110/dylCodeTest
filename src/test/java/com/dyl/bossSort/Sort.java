package com.dyl.bossSort;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author dongyuliang
 * @date 2020-03-26 0:30
 */
public class Sort {


    public TreeSet<Integer> question1(int[] a,int[] b){
        TreeSet<Integer> result = new TreeSet<>();
        int i=0,j=0,n=a.length,m=b.length;
        while (i<n&&j<m){
            if(a[i]<b[j]){
                i++;
            }else if(a[i]>b[j]){
                j++;
            }else{
                result.add(a[i]);
                i++;
                j++;
            }
        }
        return result;

    }

    static class MyThread implements Runnable {
        private static int num = 1;

        private final static int END = 75;
        private int id;

        public MyThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (num < END) {
                synchronized (MyThread.class) {
                    if (num / 3 % 3 == id) {
                        System.out.print(id + ":");
                        for (int i = 0; i < 3; i++) {
                            System.out.print(num++);
                        }
                        System.out.println();
                        MyThread.class.notifyAll();
                    }else{
                        try {
                            MyThread.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


    static class Print implements Runnable{

        static  int num = 1;
        final static int END = 75;
        int id;

        public Print(int id){
            this.id = id;
        }

        @Override
        public void run() {
            while (num <END ){
                synchronized(Print.class){
                    if(num /3% 3 == id ){
                        System.out.print(id + ":");
                        for(int i = 0;i<3;i++){
                            System.out.print(num ++);
                        }
                        System.out.println();
                        Print.class.notifyAll();
                    }else {
                        try {
                            Print.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }

    public static void deadLock(){
        Object obj1 = new Object();
        Object obj2 = new Object();
        new Thread(()->{
            synchronized (obj1){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1获取了o1锁");
                synchronized (obj2){
                    System.out.println("t1获取了o2锁");
                }
            }
        }).start();

        new Thread(() ->{
            synchronized (obj2){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2获取了o2锁");
                synchronized (obj1){
                    System.out.println("t2获取了o1锁");                }
            }
        }).start();
    }
    public static void main(String[] args) throws InterruptedException {
//        new Thread(new Print(2)).start();
//        new Thread(new Print(0)).start();
//
//        new Thread(new Print(1)).start();

        deadLock();


    }





}
