package com.dyl.springProxy;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

import javax.xml.transform.Result;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    MyInvocationHandler(){
        super();
    }

    MyInvocationHandler(Object target){
        super();
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            System.out.println("------开始执行first1");
            System.out.println("----方法的名称是："+method.getName());
             Object result = method.invoke(proxy,args);
            System.out.println("------执行first1结束");

            return result;


    }
}
