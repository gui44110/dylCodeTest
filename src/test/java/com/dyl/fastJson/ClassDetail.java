package com.dyl.fastJson;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dongyuliang
 * @date 2019-09-26 17:29
 */
public class ClassDetail {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1,2);
        list.add(null);
        list.add(null);
        list.add(1);
        System.out.println(JSONObject.toJSON(list));
    }

    @Test
    public void testJSONObject(){
        Long a = 12L;
        String c = a.toString();
        Object o = JSONObject.toJSON(a).toString();
        System.out.println(JSONObject.parseObject(c));
    }


    @Test
    public void testA(){
        Map map = new HashMap<>();
        String  a = "";
    }
}
