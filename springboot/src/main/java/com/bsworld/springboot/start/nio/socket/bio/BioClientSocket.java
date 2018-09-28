package com.bsworld.springboot.start.nio.socket.bio;
/*
*author: xieziyang
*date: 2018/9/26
*time: 17:51
*description:
*/

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class BioClientSocket {
    private static final String LOCALHOST = "127.0.0.1";
    private static final int PORT = 9999;
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
//        SocketChannel channel = socket.getChannel();
        socket.connect(new InetSocketAddress(LOCALHOST, PORT));
        System.in.read();
    }
}
