package com.dyl.genericity;

/**
 * @author dongyuliang
 * @date 2019-08-16 13:02
 */
public class Animal implements Comparable<Animal>{

    private Integer age;

    @Override
    public int compareTo(Animal o) {
        return 0;
    }
}
