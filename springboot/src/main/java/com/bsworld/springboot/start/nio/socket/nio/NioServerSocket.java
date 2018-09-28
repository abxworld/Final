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

    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.bind(new InetSocketAddress(PORT));
        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            int count = selector.select(3000);
            if (count == 0) {
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selectionKeys.stream().forEach(m -> {
                if (m.isAcceptable()) {
                    handleAccept(m);
                }
                if (m.isReadable()) {
                    handleRead(m);
                }
            });
        }
    }

    private static void handleAccept(SelectionKey selectionKey) {
        try {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
            SocketChannel acceptSocketChannel = serverSocketChannel.accept();
            acceptSocketChannel.configureBlocking(false);
            acceptSocketChannel.register(selectionKey.selector(), SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRead(SelectionKey selectionKey) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        try {
            long read = socketChannel.read(byteBuffer);
            while (read > 0) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    char c = (char) byteBuffer.get();
                    System.out.println(c);
                }
                byteBuffer.clear();
            }
            if (read == -1) {
                socketChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
