package com.bsworld.springboot.start.nio.socket.nio;
/*
*author: xieziyang
*date: 2018/9/26
*time: 18:39
*description:
*/

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class NioClientSocket {
    private static final String LOCALHOST = "127.0.0.1";
    private static final int PORT = 9999;
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        String message = "this is from client";
        socket.connect(new InetSocketAddress(LOCALHOST, PORT));
        if (socket.isConnected()) {
            OutputStream os = socket.getOutputStream();
            os.write(message.getBytes());
            os.flush();
        }
    }
}
