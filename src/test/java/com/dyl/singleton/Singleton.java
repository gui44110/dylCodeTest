package com.dyl.singleton;

public class Singleton {

    private static volatile Singleton singleton = null;

    private Singleton(){}

    private static Singleton getInstance(){

        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
