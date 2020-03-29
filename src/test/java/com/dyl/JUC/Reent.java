package com.dyl.JUC;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import javafx.concurrent.Worker;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dongyuliang
 * @date 2019-07-22 11:48
 */
public class Reent {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        lock.tryLock();

        Map<String,Object> map = new HashMap<>();
        map.put("abc",1);


    }
}
