package com.bsworld.nio.ByteBuffer;
/*
*author: xieziyang
*date: 2018/10/10
*time: 20:28
*description:
*/

import java.nio.ByteBuffer;

public class MyByteBuffer {
    public static void main(String[] args) {
        ByteBuffer bf = ByteBuffer.allocate(1024);
        bf.put((byte) 1);
        bf.flip();
    }
}
