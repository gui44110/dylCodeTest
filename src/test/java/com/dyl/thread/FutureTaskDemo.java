package com.dyl.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Classname FutureTaskDemo
 * @Date 2.12.20 4:55 下午
 * @Created by dongyuliang
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            Thread.sleep(10000);
            return 1;
        });
        new Thread(futureTask).start();
        Integer integer = futureTask.get();
    }
}
