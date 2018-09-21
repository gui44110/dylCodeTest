package com.dyl.observer;

public interface BackObserver {

    public void addObserver(Observer o);

    public void destoryObserver (Observer o);

    public void update(String content);

}
