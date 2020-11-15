package com.dyl.thread;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname LockTest
 * @Date 27.10.20 10:27 上午
 * @Created by dongyuliang
 */
public class LockTest {

    private int i = 1;


    @Test
    public void test1() throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        lock.lock();
        i++;
        condition.wait();
        lock.unlock();
    }
}
