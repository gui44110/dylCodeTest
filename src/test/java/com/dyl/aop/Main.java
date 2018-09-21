package com.dyl.aop;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        UserServiceImpl service = new UserServiceImpl();

        MyInvocationHandler invoke = new MyInvocationHandler(service);

        UserService proxService = (UserService) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(),service.getClass().getInterfaces(),invoke);

        proxService.eat();

    }
}
