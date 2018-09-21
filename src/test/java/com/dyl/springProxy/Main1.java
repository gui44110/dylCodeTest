package com.dyl.springProxy;

import java.lang.reflect.Proxy;

public class Main1 {

    public static void main(String[] args) {
        TargetInter target = new Target();

        MyInvocationHandler invocationHandler = new MyInvocationHandler(target);

        TargetInter proxy = (TargetInter) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),invocationHandler);

        proxy.first1();
    }
}
