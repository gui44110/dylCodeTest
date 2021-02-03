package com.dyl.code.other;

/**
 * @Classname CircularPrintABC
 * @Description 三个线程循环打印ABC
 * @Date 19.11.20 10:28 上午
 * @Created by dongyuliang
 */
public class CircularPrintABC {

    public static void main(String[] args) {
        int state = 1;
        new Thread(() -> {
            synchronized (CircularPrintABC.class) {
                for (int i = 0; i < 10; i++) {
                    if(state %3 == 1){
                        System.out.println("A");
                    }
                }
            }
        }).start();
    }
}