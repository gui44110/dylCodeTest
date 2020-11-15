package com.dyl.thread;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: dongyuliang@meicai.cn
 * @Date: 2019/1/2 18:14
 */
public class MyThread {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(20);


    public static void main(String[] args) {
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(10);
        MyThread myThread = new MyThread();
        myThread.run1();
        myThread.run1();
    }
    public void run1(){
        long start = System.currentTimeMillis();
        for(int i = 0;i<10;i++){
            for(int j = 0 ;j<100;j++){
                int finalJ = j;
                executorService.submit(() -> runTask(finalJ));
            }
        }
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                long end = System.currentTimeMillis();
                System.out.println("结束了！");
                System.out.println(end - start);
                break;
            }
        }
        System.out.println("-------------");
    }


    public void runTask(int i){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);;
    }
}
