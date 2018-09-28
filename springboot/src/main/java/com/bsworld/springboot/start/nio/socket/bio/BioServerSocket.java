package com.bsworld.springboot.start.nio.socket.bio;
/*
*author: xieziyang
*date: 2018/9/26
*time: 17:46
*description:
*/

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

public class BioServerSocket {
    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket();
        ServerSocketChannel channel = ss.getChannel();
        System.out.println(channel);
        ss.bind(new InetSocketAddress(PORT));
        while (true) {
            Socket accept = ss.accept();
            System.out.println(accept);
        }
    }
}
