package com.dyl.observer;

import java.util.ArrayList;
import java.util.List;

public class BackObserverClass  implements BackObserver{


    private List<Observer> list = new ArrayList<Observer>();

    public void addObserver(Observer o) {
        list.add(o);
        System.out.println("添加观察者"+o.getClass().getName());
    }

    public void destoryObserver(Observer o) {
        if(list.contains(o)){
            list.remove(o);
            System.out.println("删除观察者"+o.getClass().getName());
        }
    }

    public void update(String content) {
    for(Observer o:list){
        o.read(content);
    }
    }

    public static void main(String[] args) {
        Observer a = new ObserverClassA();

        Observer b = new ObserverClassB();
        BackObserver backObserver = new BackObserverClass();

        backObserver.addObserver(a);

        backObserver.addObserver(b);

        backObserver.update("发布文章1");

        backObserver.destoryObserver(a);

        backObserver.update("发布文章2");

        Observer c = new Observer() {
            public void read(String content) {
                System.out.println("我收到了消息，但是我暂时不想看了");

            }
        };
        backObserver.addObserver(c);

        backObserver.update("发布文章3");

    }
}
