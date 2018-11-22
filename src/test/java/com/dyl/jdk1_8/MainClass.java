package com.dyl.jdk1_8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {


    @Test
    public void testStream(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        List<String> filter2 = strings.stream().filter( string -> !string.equals("")).collect(Collectors.toList());
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        filtered.stream().filter(string -> !string.equals("bc")).forEach(value -> System.out.println(value));
        System.out.println("-------");
        filtered.forEach(value -> System.out.println(value));
    }
}
