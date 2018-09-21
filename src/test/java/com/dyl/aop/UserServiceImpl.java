package com.dyl.aop;

public class UserServiceImpl implements  UserService{
    public void eat() {
        System.out.println("正在吃饭中。。。。。。");
    }

    public void run() {
        System.out.println("正在奔跑中。。。。。。");
    }
}
