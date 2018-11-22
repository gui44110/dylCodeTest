package com.dyl.singleton;

/**
 * @Author: dongyuliang@meicai.cn
 * @Date: 2018/11/22 16:26
 */
public class Singleton3 {

    private Singleton3(){}

    private static class SingletonHold{
        final static Singleton3 INTANCE = new Singleton3();
    }

    private Singleton3 getInstance(){
        return SingletonHold.INTANCE;
    }
}
