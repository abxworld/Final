package com.bsworld.nio.selector;
/*
*author: xieziyang
*date: 2018/4/18
*time: 9:29
*description:
*/

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

public class ChatClient {


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for (int i = 1; i < 100; i++) {
            final int idx = i;
            new Thread(new MyRunnable(idx)).start();
        }
    }
    private static class MyRunnable implements Runnable {

        private final int idx;

        private MyRunnable(int idx) {
            this.idx = idx;
        }
        @Override
        public void run() {
            // TODO Auto-generated method stub
            SocketChannel socketChannel = null;
            try {
                socketChannel = SocketChannel.open();
                SocketAddress socketAddress = new InetSocketAddress("localhost", 8080);

                socketChannel.connect(socketAddress);

                SendAndReceiveUtil.sendData(socketChannel, "My id is " + idx);

                String msg = SendAndReceiveUtil.receiveData(socketChannel);
                if(msg != null) System.out.println("The server reply:"+msg);

                SendAndReceiveUtil.sendData(socketChannel,"bye");

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    socketChannel.close();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }


    }
}

