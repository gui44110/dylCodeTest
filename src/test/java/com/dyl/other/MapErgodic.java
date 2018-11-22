package com.dyl.other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapErgodic {

    public  static void map1(Map map){

        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext());

        Map.Entry obj = (Map.Entry)iterator.next();

        System.out.println("key:"+obj.getKey()+",value"+obj.getValue());

    }

    public static void testList(List<Integer> list){
        list.forEach(integer ->{
            System.out.println(integer);
        });
    }

    public static void main(String[] args) {
        List l = new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        testList(l);

    }


}
