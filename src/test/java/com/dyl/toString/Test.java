package com.dyl.toString;

import com.dyl.reference.Person;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author dongyuliang
 * @date 2019-07-16 10:18
 */
public class Test {

    public static void main(String[] args) throws NoSuchMethodException, ExecutionException, InterruptedException {

        Integer a = new Integer(1);
        System.out.println(1 == 1L);
        String str = "";
//        for(int i = 0;i<64;i++){
//            str +="select count(1) num from area_shop_su_"+i+" where u_t >= 1582962480 union all ";
//        }
//        System.out.println(str);
//        BigDecimal b = new BigDecimal("0.2");
//        BigDecimal c = BigDecimal.valueOf(0.2);
//        BigDecimal d = c.setScale(3);
//
//        int minInteger = min(new Integer[]{1, 2, 3});
//        System.out.println(minInteger);
//        double minDouble = min(new Double[]{2.2, 2.2, -1d});
//        System.out.println(minDouble);
//
//        int[] ints = {1,2,3};
//        int[] ints1 = Arrays.copyOf(ints, 2);
//        System.out.println(Arrays.toString(ints));
//        System.out.println(Arrays.toString(ints1));
//
//        Class<Integer> integerClass = Integer.class;
//        Method add = integerClass.getMethod("add", Object.class);
//        LinkedList<Person> objects = Lists.newLinkedList();
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        Spliterator<String> spliterator = list.spliterator();
//
//        HashMap<Object, Object> objectObjectHashMap = Maps.newHashMap();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Object> future = executorService.submit(() -> {
            System.out.println("验证空指针问题");
            return null;
        });
        System.out.println("-----------");
        future.get();

    }



    public static <T extends Number & Comparable<? super T>> T min(T[] values){
        if(values == null || values.length == 0){
            return null;
        }
        T min = values[0];
        for(int i = 1 ;i<values.length;i++){
            if(values[i].compareTo(min)==1){
                min = values[i];
            }
        }
        return min;
    }


}

