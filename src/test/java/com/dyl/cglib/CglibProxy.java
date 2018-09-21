package com.dyl.cglib;

import com.dyl.aop.UserServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Object object){
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        Object result ;
        if("eat".equals(method.getName())) {
            System.out.println(method.getName());
            System.out.println("代理之前111");
             result = methodProxy.invokeSuper(o, objects);
            System.out.println("代理之后111");

        }else{
            System.out.println(method.getName());
            System.out.println("代理之前222");
             result = methodProxy.invokeSuper(o, objects);
            System.out.println("代理之后222");
            return result;
        }

        return result;

    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();

        UserServiceImpl userService = (UserServiceImpl) cglibProxy.getProxy(new UserServiceImpl());

        userService.eat();

        userService.run();


    }
}
