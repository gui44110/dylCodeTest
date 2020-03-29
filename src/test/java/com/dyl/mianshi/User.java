package com.dyl.mianshi;

import com.alibaba.fastjson.JSONArray;
import com.dyl.sort.SortClass;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dongyuliang
 * @date 2020-03-26 13:55
 */
public class User {

    private final static int imit = Integer.MAX_VALUE;

    private Integer age;

    private static void run() {
    }

    private Integer getAge(){
        return age;
    }

    public static void remove(List<User> userList){
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()){
            User next = iterator.next();
            if(next.getAge()>20){
                iterator.remove();
            }
        }
    }


    public static void print(int[] arry){
        int[] result = {imit,imit,imit,imit,imit,imit,imit,imit,imit,imit};
        for(int i = 0;i<arry.length;i++){
            int j;
            int num = arry[i];
            for(j = 9;j>0&&result[j]>num;j--){
                result[j] = result[j-1];
            }
            if(j<9){
                result[j] = num;
            }
        }
        System.out.println(JSONArray.toJSON(result));

    }

    public static void insertSort(int[] array){
        for(int i = 1;i<array.length;i++){
            int j;
            int num = array[i];
            for(j = i;j>0&&array[j-1]>num;j--){
                array[j] = array[j-1];
            }
            array[j] = num;
        }
        System.out.println(JSONArray.toJSON(array));
    }



    public static void main(String[] args) {
//        int[] array = {4,1,3,53,23,2,3,4,5,6,188,12,4,4,5,6,8,9,2,4,5,6};
//        print(array);
//        insertSort(array);
        method1();

        Map map = new ConcurrentHashMap();
    }



    public static void method1(){
        new Thread(() -> {
            synchronized (SortClass.class){
                while (true){
                    if(flag== 1) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("A线程打印A");
                        flag = 2;
                        SortClass.class.notifyAll();
                    }else {
                        try {
                            SortClass.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }).start();

        new Thread(() -> {
            synchronized (SortClass.class){
                while (true){
                    if(flag== 2) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("B线程打印B");
                        flag = 3;
                        SortClass.class.notifyAll();
                    }else {
                        try {
                            SortClass.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }).start();


        new Thread(() -> {
            synchronized (SortClass.class){
                while (true){
                    if(flag== 3) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("C线程打印C");
                        flag = 1;
                        SortClass.class.notifyAll();
                    }else {
                        try {
                            SortClass.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }).start();
    }

    private static int flag = 1;


    static class MyThread implements Runnable{

        private int flag;

        private String name;

        private String lock;

        private int time = 1;

        public MyThread(int flag ,String name,String lock){
            this.flag = flag;
            this.name = name;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true){
                synchronized (lock){
                    if(time%3 == flag){
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(name + "线程开始打印" + name);
                        time ++;
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        lock.notifyAll();
                    }
                }
            }
        }
    }



}
