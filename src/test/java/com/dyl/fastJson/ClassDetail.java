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
    public void testA(){
        Map map = new HashMap<>();
        String  a = "";
    }

    @Test
    public void testJSONObject(){
        String str = "{\"person\":{\"id\":1234}}";
        JSONObject jsonObject = JSONObject.parseObject(str, JSONObject.class);
    }
}
