package com.dyl.jdk1_8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

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
    }
}
