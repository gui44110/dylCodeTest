package com.dyl.collection;

import com.dyl.json.Man;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: dongyuliang@meicai.cn
 * @Date: 2019/1/21 15:14
 */
public class ListCollection {

    @Test
    public void testList(){
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

        List<Man> men = list.subList(0,0);

        System.out.println(men.toString());

    }

}
