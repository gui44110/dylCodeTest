package com.dyl;

import com.dyl.json.Person;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: dongyuliang@meicai.cn
 * @Date: 2018/12/5 16:59
 */
@Slf4j
public class testAdd {

    public static void main(String[] args) {

        Person person = new Person();
        person.setAge(1);
        person.setName("123");
        log.info("persion is :{}" ,person);

    }

    public static void println(int start,int end){
        System.out.println("start:"+start+",end:"+end);
    }


    public static int a(){
        return 1;
    }
}
