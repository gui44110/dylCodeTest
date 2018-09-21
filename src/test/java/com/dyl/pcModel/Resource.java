package com.dyl.pcModel;

import javax.xml.bind.SchemaOutputResolver;

public class Resource {

    private int num = 0;

    private  int maxNum ;

    public Resource(int maxNum){
        this.maxNum = maxNum;
    }

    public synchronized  void produce(){
        if(num<maxNum){
            num++;
            System.out.println("线程"+Thread.currentThread().getName()+"生产了1个产品，剩余"+num);
            notifyAll();
        }else{
            System.out.println("线程"+Thread.currentThread().getName()+"进入等待中。。。。。");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized  void consume(){
        if(num>0){
            num--;
            System.out.println("线程"+Thread.currentThread().getName()+"消费了1个产品，剩余"+num);
            notifyAll();
        }else{
            System.out.println("线程"+Thread.currentThread().getName()+"进入等待中。。。。。");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
