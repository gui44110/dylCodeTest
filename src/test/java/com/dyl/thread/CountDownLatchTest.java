package com.dyl.thread;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @Classname CountDownLatch
 * @Description TODO
 * @Date 9.9.20 8:06 下午
 * @Created by dongyuliang
 */
public class CountDownLatchTest {

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Test
    public void call(){
        List<String> objects = Lists.newArrayList();
        objects.add(null);
        objects.add("1");
        Map<Object, Object> collect = objects.stream().collect(Collectors.toMap(p -> p, p -> p));
        System.out.println(11111);
    }

}
