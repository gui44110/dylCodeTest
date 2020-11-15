package com.dyl.netty;

import io.netty.buffer.UnpooledDirectByteBuf;
import org.junit.Test;
import sun.nio.ch.DirectBuffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

/**
 * @Classname BaseClass
 * @Date 26.10.20 9:24 下午
 * @Created by dongyuliang
 */
public class BaseClass {


    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(10);
    }
}
