package com.bsworld.springboot.start.nio.socket.nio;
/*
*author: xieziyang
*date: 2018/9/26
*time: 17:59
*description:
*/

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class NioServerSocket {
    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.bind(new InetSocketAddress(PORT));
        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("sleep start");
        Thread.sleep(3000);
        System.out.println("sleep end");
        while (true) {
            System.out.println("while start");
            int count = selector.select();
            System.out.println("while end, count: " + count);
            if (count == 0) {
                continue;
            }
            System.out.println("threadName: " + Thread.currentThread().getName());
            Set<SelectionKey> keys = selector.selectedKeys();
            keys.stream().forEach(m -> {
                if (m.isAcceptable()) {
                    handleAccept(m);
                }
                if (m.isReadable()) {
                    handleRead(m);
                }
                if (m.isWritable() && m.isValid()) {
                    handleWrite(m);
                }
            });
            keys.clear();
        }
    }

    private static void handleAccept(SelectionKey selectionKey) {
        try {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
            SocketChannel acceptSocketChannel = serverSocketChannel.accept();
            acceptSocketChannel.configureBlocking(false);
            acceptSocketChannel.register(selectionKey.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(1024));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRead(SelectionKey selectionKey) {

        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
        try {
            long read = socketChannel.read(byteBuffer);
            while (read > 0) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    char c = (char) byteBuffer.get();
                    System.out.print(c);
                }
                byteBuffer.clear();
               read =  socketChannel.read(byteBuffer);
            }
            handleWrite(selectionKey);
            if (read == -1) {
                socketChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleWrite(SelectionKey key) {
        SocketChannel channel = (SocketChannel) key.channel();
        if (channel.isConnected()) {
            ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
            String message = "this is from server";
            try {
                byteBuffer.clear();
                byteBuffer.put(message.getBytes());
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    if (channel.isConnected()) {
                        channel.write(byteBuffer);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("client shut down");
        }

    }
}
