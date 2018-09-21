package com.dyl.springProxy;


public class Target implements TargetInter{

    public void first1(){
        System.out.println("**执行fisrt1方法");
    }

    public void other1(){
        System.out.println("##执行others方法");
    }

    public void other2(){
        System.out.println("##执行other2方法");
    }


}
