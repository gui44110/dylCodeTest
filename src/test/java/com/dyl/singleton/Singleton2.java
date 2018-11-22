package com.dyl.singleton;

/**
 * 此方式属于懒汉式加载，有点在使用到改类的时候，在进行实例化，不至于造成内存资源浪费，问题，在多线程是不安全的
 * @Author: dongyuliang@meicai.cn
 * @Date: 2018/11/22 16:20
 */
public class Singleton2 {

    private static Singleton2 singleton2 = null;

    private Singleton2(){}

    public Singleton2 getInstance(){
        if(singleton2 == null ){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
