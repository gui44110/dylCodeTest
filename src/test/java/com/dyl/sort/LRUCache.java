package com.dyl.sort;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author dongyuliang
 * @date 2020-04-15 15:30
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private final  int CACHE_SIZE;

    public LRUCache(int size){
        super((int )Math.ceil(size*0.75) + 1,0.75f,true);
        this.CACHE_SIZE = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>CACHE_SIZE;

    }
}
