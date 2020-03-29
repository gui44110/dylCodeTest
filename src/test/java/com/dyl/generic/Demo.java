package com.dyl.generic;

/**
 * @author dongyuliang
 * @date 2019-12-20 15:44
 */
public class Demo {

    public static <T> void test1(T t){
        System.out.println(t);
    }


    public static void main(String[] args) {
        Demo.test1(1);
    }
}
