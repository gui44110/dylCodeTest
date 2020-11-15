package com.dyl.collection;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Classname SetCollection
 * @Date 27.9.20 11:13 上午
 * @Created by dongyuliang
 */
public class SetCollection {

    @Test
    public void test1(){
        Set<String> sets = Sets.newHashSet();
        System.out.println(sets.toString());
        System.out.println(sets.stream().collect(Collectors.joining(",")));
    }
}
