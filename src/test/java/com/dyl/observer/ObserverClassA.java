package com.dyl.observer;

public class ObserverClassA  implements Observer {


    public void read(String content) {
        System.out.println("观察者"+this.getClass().getName()+"收到了"+content);
    }
}
