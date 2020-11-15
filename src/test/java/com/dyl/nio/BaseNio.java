package com.dyl.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @Classname BaseNio
 * @Description TODO
 * @Date 5.6.20 8:08 下午
 * @Created by dongyuliang
 */
public class BaseNio {

    @Test
    public void baseTest(){
        ByteBuffer allocate = ByteBuffer.allocate(10);
        ByteBuffer.wrap(new byte[10]);
        allocate.put("hello".getBytes());
        allocate.flip();
    }
}
