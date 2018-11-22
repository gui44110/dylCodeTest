package com.dyl.singleton;

/**
 *
 * 单例模式的总体特征：在内存中只有一个实例化对象，保证了内存的重复利用，实现特性，构造方法必须用private，static修改，保证此类在内存中唯一
 *
 * 恶汉式单利，在类在加载的时候就直接单利，这样方式缺点，没有实现懒加载，即在类被加载的时候就已经实例化对象，造成空间的浪费，
 * @Author: dongyuliang@meicai.cn
 * @Date: 2018/11/22 16:14
 */
public class Singleton1 {

    private static Singleton1 singleton = new Singleton1();

    private Singleton1(){}

    private Singleton1 getInstance(){
        return singleton;
    }
}
