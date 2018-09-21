package com.bsworld.nio;
/*
*author: xieziyang
*date: 2018/4/24
*time: 5:56
*description:
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class channel {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\hello.txt");
        FileChannel channel = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(8);
        channel.read(buffer);
        buffer.flip();
        while (buffer.remaining() > 0) {
            byte b = buffer.get();
            System.out.print(((char) b));
        }
        fis.close();
    }
}
