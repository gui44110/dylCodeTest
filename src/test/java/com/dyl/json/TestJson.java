package com.dyl.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: dongyuliang@meicai.cn
 * @Date: 2019/1/18 17:31
 */
public class TestJson {

    @Test
    public void testJsonArray(){


        Man m1 = new Man();
        m1.setName("张三");
        m1.setSex("男");
        m1.setOther("搬砖");

        Man m2 = new Man();
        m2.setName("李四");
        m2.setSex("男");
        m2.setOther("女工");

        Man m3 = new Man();
        m3.setName("张三");
        m3.setSex("男");
        m3.setOther("女工");

        List<Man> list = new ArrayList();

        list.add(m1);

        list.add(m2);

        list.add(m3);

        List<Man> list2 = list.stream().distinct().collect(Collectors.toList());

        System.out.println(list2.size());

        for(Man m:list2){
            System.out.println(m.getName()+m.getSex()+":"+m.getOther());
        }

    }

    @Test
    public void testNullStringJson(){
        String jsonData = "{}";

        Person p = JSONObject.parseObject(jsonData,Person.class);

        System.out.println(p.toString());


        String jsonData2 = "[]";
        List<Person> list = JSONArray.parseArray(jsonData2,Person.class);
        System.out.println(list.toString());

    }
}
