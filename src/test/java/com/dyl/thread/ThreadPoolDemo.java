package com.dyl.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @Classname ThreadPoolDemo
 * @Description TODO
 * @Date 18.5.20 11:21 上午
 * @Created by dongyuliang
 */
public class ThreadPoolDemo {

    public static ExecutorService CACHED_THREAD_POOL = Executors.newFixedThreadPool(5);

    @Test
    public void testCallablePool() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Integer> paramList = new ArrayList<>();
        List<Callable<String>> list = new ArrayList<>();
        for(int i = 0 ; i<100;i++){
            paramList.add(i);
        }
        List<Callable<String>> collect2 = paramList.stream().map(p -> (Callable<String>) () ->
        {  System.out.println("当前现成:"+Thread.currentThread().getName());
            return "result" + p;}).collect(Collectors.toList());
        List<Future<String>> collect = collect2.stream().map(p -> executorService.submit(p)).collect(Collectors.toList());
    }


    public <R> R exceptionHandle(Future<R> future){
        R result = null;
        try {

            result =future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static <R> R checkedException2unchecked(Callable<R> var0) {
        try {
            return var0.call();
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }

    public static <R> List<Future<R>> submitCallables(List<Callable<R>> var0) {
        return var0.stream().map((var0x) -> CACHED_THREAD_POOL.submit(var0x)
        ).collect(Collectors.toList());
    }


}
