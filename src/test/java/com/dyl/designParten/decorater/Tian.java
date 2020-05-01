package com.dyl.designParten.decorater;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

/**
 * @author dongyuliang
 * @date 2020-03-11 11:37
 */
public class Tian implements Coffee {

    private Coffee coffee;

    public Tian(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public void getCoffee() {
        System.out.println("加点糖");
        coffee.getCoffee();
    }


    public static void main(String[] args) {
        List collection = Lists.newArrayList();
        HashMap<Object, Object> map = Maps.newHashMap();

        ListIterator listIterator = collection.listIterator();
        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() ->1);
        ThreadLocal<Integer> threadLocal2 = ThreadLocal.withInitial(() -> 2);
        Integer integer = threadLocal.get();

        ExecutorService executorService = Executors.newFixedThreadPool(30);

        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.incrementAndGet();


//        for(int j =0; j<10;j++){
            new Thread(()-> {
                    Integer integer1 = threadLocal.get();
                    Integer integer2 = threadLocal2.get();
                    System.out.println(threadLocal.get());
                    System.out.println(threadLocal2.get());
                }
                ).start();
//        }
////
////        Executors.newCachedThreadPool();
//        List<Integer> list = new ArrayList<>(0);
//        list.add(1);
//        list.add(2);


    }
}
