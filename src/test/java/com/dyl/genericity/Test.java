package com.dyl.genericity;

/**
 * @author dongyuliang
 * @date 2019-08-16 12:52
 */
public class Test {

    public static <T extends Number & Comparable<? super T>> T min(T[] value){
        return null;

    }
}
