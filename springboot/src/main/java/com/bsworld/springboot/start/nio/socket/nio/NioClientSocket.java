package com.bsworld.springboot.start.nio.socket.nio;
/*
*author: xieziyang
*date: 2018/9/26
*time: 18:39
*description:
*/

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class NioClientSocket {
    private static final String LOCALHOST = "127.0.0.1";
    private static final int PORT = 9999;
    private static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        sc.connect(new InetSocketAddress(LOCALHOST, PORT));
        ByteBuffer bf = ByteBuffer.allocateDirect(1024);
        if (sc.finishConnect()) {
            TimeUnit.SECONDS.sleep(1);
            String message = "this is from client-- " + ai.getAndIncrement();
            bf.clear();
            bf.put(message.getBytes());
            bf.flip();
            while (bf.hasRemaining()) {
                System.out.println("client: " + bf);
                sc.write(bf);
            }
        }
        bf.clear();
        while (true) {
            int read = sc.read(bf);
            System.out.println(read);
        }
    }

 /*public static void main(String[] args) throws IOException {
     Socket socket = new Socket();
     socket.connect(new InetSocketAddress(LOCALHOST,PORT));
     InputStream is = socket.getInputStream();
     int read = is.read();
     while (read != -1) {
         System.out.println((char)read);
         read = is.read();
     }*/
 }

