package com.dyl.localCache;

import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.Test;

/**
 * @Classname LocalCacheTest
 * @Date 10.10.20 12:16 下午
 * @Created by dongyuliang
 */
public class LocalCacheTest {

    private Cache<String,String> cache = CacheBuilder.newBuilder().build();

    @Test
    public void test1(){
        double d = 20.0;
        System.out.println(JSONObject.toJSONString(d));
    }
}
