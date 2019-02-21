package com.dyl.json;

import com.alibaba.fastjson.JSON;

/**
 * @Author: dongyuliang@meicai.cn
 * @Date: 2019/1/18 17:31
 */
public class TestJson {

    public static void main(String[] args) {
        String json = "{'name':'lisi','age':6,'sex':'man'}";
        Person user1 = JSON.parseObject(json, Person.class);
        System.out.println(user1.getName()+":" + user1.getAge());
    }
}
