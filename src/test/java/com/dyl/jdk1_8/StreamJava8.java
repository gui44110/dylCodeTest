package com.dyl.jdk1_8;

import com.dyl.pcModel.Consumer;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJava8 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "abc", "bc", "efg", "abcd","", "jkl");

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        List<String> strings2 = strings.stream().distinct().collect(Collectors.toList());

        System.out.println(strings2);

        List<Integer> number2 = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());

        System.out.println(number2);


        IntSummaryStatistics stats = numbers.stream().mapToInt((x) ->x).summaryStatistics();

        System.out.println("最大值："+stats.getMax());

        java.util.function.Consumer o =o1 ->  System.out.println(1);

        new HashMap<>();

        new ArrayList<>();



    }
}
