package com.dyl.reference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: dongyuliang@meicai.cn
 * @Date: 2018/10/18 10:41
 */
public class ReferenceTest {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        ReferenceTest test = new ReferenceTest();
        Person  p1 = new Person();

        p1.setAge(1);

        p1.setName("zhangsan");
        list.add(p1);
        Person  p2 = new Person();
        p2.setAge(2);
        p2.setName("lisi");
        list.add(p2);

        Map<Integer,Person> map = list.stream().collect(Collectors.toMap(Person::getAge, Function.identity()));

        Person p3 = map.get(1);
        p3.setName("王五");

        for(Person p : list){
            System.out.println(p.getName()+":"+p.getAge());
        }



    }

    public void updateAge(Person p1){
        p1.setAge(20);
    }

}
