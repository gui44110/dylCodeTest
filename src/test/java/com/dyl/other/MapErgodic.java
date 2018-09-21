package com.dyl.other;

import java.util.Iterator;
import java.util.Map;

public class MapErgodic {

    public  static void map1(Map map){

        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext());

        Map.Entry obj = (Map.Entry)iterator.next();

        System.out.println("key:"+obj.getKey()+",value"+obj.getValue());

    }


}
