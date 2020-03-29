package com.dyl.jdk1_8;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LamabaTest {

    public static void main(String[] args) {

    Map<Integer,Object> map = new HashMap<>();
    map.put(1,"2");
    if(!map.containsKey(2) ||map.get(2).toString() == ""){
        System.out.println("1111111");
    }

    }

    @Test
    public void testFindFirst(){
        List<Pair<Integer,Integer>> list = new ArrayList<>();

        Pair<Integer, Integer> of = Pair.of(1, 2);

//        list.add(of);
        Integer value = list.stream().findFirst().orElse(Pair.of(null,null)).getRight();
        System.out.println(value);
    }
}
