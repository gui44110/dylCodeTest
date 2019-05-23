package com.dyl.json;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: dongyuliang@meicai.cn
 * @Date: 2019/1/18 17:32
 */
@Getter
@Setter
@EqualsAndHashCode(of = {"age"})
public class Person {

    private String name;

    private String age ;

}
