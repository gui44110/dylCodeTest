package com.dyl.generic;

import lombok.experimental.Helper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dongyuliang
 * @date 2019-12-20 15:46
 */
public class Demo2<T> {

    T field;

    public T getField() {
        return field;
    }

    public void setField(T field) {
        this.field = field;
    }

    public static void main(String[] args) {
        Demo2<String> demo = new Demo2<>();
        demo.setField("123");
        System.out.println(demo.getField());
    }

    @Test
    public void test1(){
        List<? extends Number> list= new ArrayList<>();

        Number a = new Integer(1);

        Number b = new Double(1.1);
    }


    private static <T extends Number & Comparable> T min(T[] values){
        if (values == null || values.length == 0) return null;
        T min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (min.compareTo(values[i]) > 0) min = values[i];
        }
        return min;
    }

    @Test
    public void test(){
        int minInteger = min(new Integer[]{1, 2, 3});//result:1
        double minDouble = min(new Double[]{1.2, 2.2, -1d});//result:-1d
    }


    public static <T extends Number & Comparable<? super Number>> Boolean inRange(T value, T minRange, T maxRange) {
        //  equivalent (value >= minRange && value <= maxRange)
        if (value.compareTo(minRange) >= 0 && value.compareTo(maxRange) <= 0)
            return true;
        else
            return false;
    }

    @Test
    public void test2(){
        Integer value = 2;
        Integer min = 3;
        Integer max = 8;
    }




}

