package com.dyl.designParten.decorater;

import org.junit.Test;

/**
 * @author dongyuliang
 * @date 2020-03-11 11:35
 */
public class KuCoffee implements Coffee {


    @Override
    public void getCoffee() {
        System.out.println("这是苦咖啡");
    }
}
