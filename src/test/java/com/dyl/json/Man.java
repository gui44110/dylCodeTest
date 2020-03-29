package com.dyl.json;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true,of = "name,sex")
public class Man extends Person {
    private String sex;

    private String other;
}
