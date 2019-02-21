package com.dyl.spring;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: dongyuliang@meicai.cn
 * @Date: 2018/12/18 16:43
 */
public class AutoController {

    @Autowired
    private AutoService autoService;

    public void testAutowired(){
        autoService.getInt();
    }

}
