package com.dyl.thread;

import org.junit.Test;

/**
 * @Classname ThreadLocalTest
 * @Date 25.9.20 5:59 下午
 * @Created by dongyuliang
 */
public class ThreadLocalTest {

    @Test
    public void test1(){
//        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 10);
//
//        ThreadLocal<String> threadLocal2 = ThreadLocal.withInitial(() -> "a");
//
//        threadLocal.set(20);
//        threadLocal2.set("b");
//
//        Integer integer = threadLocal.get();
//        String s = threadLocal2.get();
//        System.out.println(integer);
//        System.out.println(s);
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(1);

    }


}
