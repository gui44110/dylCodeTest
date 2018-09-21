package com.dyl.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    Object target;

    public MyInvocationHandler(){
        super();
    }

    public MyInvocationHandler(Object target){
        super();
        this.target = target;

    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法之前");
        Object result = method.invoke(target,args);
        System.out.println("执行方法之后");
        return result;
    }
}
