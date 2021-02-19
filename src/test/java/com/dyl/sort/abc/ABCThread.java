package com.dyl.sort.abc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname ABC
 * @Description 3个线程交替打印ABC
 * @Date 25.1.21 8:55 下午
 * @Created by dongyuliang
 */
public class ABCThread {

    static Thread threadA = null, threadB = null, threadC = null;


    public static void main(String[] args) throws InterruptedException {
        ABCThread abcThread = new ABCThread();
//        abcThread.method1();
//        abcThread.method2();
//        abcThread.method3();
        abcThread.method4();
    }

    /**
     * 使用LockSupport 的pack() 和unpack(),实现线程的等待
     */
    public void method1() throws InterruptedException {
        threadA = new Thread(() -> {
            while (true) {
                System.out.println("A");
                LockSupport.unpark(threadB);
                LockSupport.park();
            }
        });

        threadB = new Thread(() -> {
            while (true) {
                System.out.println("B");
                LockSupport.unpark(threadC);
                LockSupport.park();
            }
        });

        threadC = new Thread(() -> {
            while (true) {
                System.out.println("C");
                LockSupport.unpark(threadA);
                LockSupport.park();
            }
        });

        threadA.start();

        threadB.start();
        threadC.start();
    }


    public void method2() throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        Thread threadA = new Thread(new Method2Print("A", c, a));
        Thread threadB = new Thread(new Method2Print("B", a, b));
        Thread threadC = new Thread(new Method2Print("C", b, c));

        threadA.start();
        Thread.sleep(100);
        threadB.start();
        Thread.sleep(100);
        threadC.start();
    }

    /**
     * 使用lock + condition
     */
    public void method3() {
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        new Thread(() -> {
                try {
                    lock.lock();
                    int i = 0;
                    while (i < 10) {
                        System.out.println("A");
                        i++;
                        conditionB.signal();
                        conditionA.await();
                    }
                    conditionB.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                int i = 0;
                while (i < 10) {
                    System.out.println("B");
                    i++;
                    conditionC.signal();
                    conditionB.await();
                }
                conditionC.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();


        new Thread(() -> {
            try {
                lock.lock();
                int i = 0;
                while (i < 10) {
                    System.out.println("C");
                    i++;
                    conditionA.signal();
                    conditionC.await();
                }
                conditionA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();
    }

    /**
     * 基于信号量
     */
    public void method4(){
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);

        new Thread(() -> {
                try {
                    for (int i = 0 ; i< 10;i++){
                        semaphoreA.acquire();
                        System.out.println("A");
                        semaphoreB.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }).start();

        new Thread(() -> {
            try {
                for (int i = 0 ; i< 10;i++){
                    semaphoreB.acquire();
                    System.out.println("B");
                    semaphoreC.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();


        new Thread(() -> {
            try {
                for (int i = 0 ; i< 10;i++){
                    semaphoreC.acquire();
                    System.out.println("C");
                    semaphoreA.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }

    class Method2Print implements Runnable {

        private String str;

        private Object pre;

        private Object self;

        public Method2Print(String str, Object pre, Object self) {
            this.str = str;
            this.pre = pre;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 0;
            while (count < 10) {
                synchronized (pre) {
                    synchronized (self) {
                        System.out.println(str);
                        count++;
                        self.notifyAll();
                    }

                    if (count == 10) {
                        pre.notifyAll();
                    }else {
                        try {
                            pre.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
