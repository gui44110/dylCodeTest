package com.dyl.thread;

public class TestSynchronized {

    public synchronized  void test1(){
        for(int i=5;i>0;i--){
            try {
                Thread.sleep(3000);
                System.out.println("线程："+Thread.currentThread().getName()+"i的值"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized static void test2(){
        for(int i=5;i>0;i--){
            try {
                Thread.sleep(3000);
                System.out.println("线程："+Thread.currentThread().getName()+"i的值"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized static void test3() {
        synchronized (TestSynchronized.class) {
            for (int i = 5; i > 0; i--) {
                try {
                    Thread.sleep(3000);
                    System.out.println("线程：" + Thread.currentThread().getName() + "i的值" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void test4(){
    }

    public static void main(String[] args) {
        final TestSynchronized test1 = new TestSynchronized();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                test1.test3();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                test1.test2();
            }
        });

        t1.start();

        t2.start();
    }
}
