package com.bsworld.nio.selector;
/*
*author: xieziyang
*date: 2018/4/18
*time: 9:27
*description:
*/

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class ChatServer {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        final Selector selector = Selector.open();;

        ServerSocketChannel ssc = ServerSocketChannel.open();

        try{
            // Bind the server socket to the local host and port
            ssc.socket().bind(new InetSocketAddress("localhost", 8080));

            //start a thread to handle the wirte and read
            startWRThread(selector);
            //block the main thread to accept client
            while(true){  // will block the thread

                SocketChannel sc = ssc.accept();
                //Get the server socket and set to non blocking mode
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ);
            }
        }finally{
            selector.close();
            ssc.close();
        }
    }

    private static void startWRThread(final Selector selector) {
        // TODO Auto-generated method stub
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    while(true){
                        while(selector.selectNow() > 0){

                            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                            //// Walk through the ready keys collection and process date requests.
                            while(it.hasNext()){
                                SelectionKey readyKey = it.next();
                                if(readyKey.isReadable()){
                                    SocketChannel sc = (SocketChannel) readyKey.channel();
                                    String msg = SendAndReceiveUtil.receiveData(sc);
                                    if(msg != null && !msg.equals("")) {
                                        if(msg.equals("bye")){
                                            System.out.println("Get a msg : " + msg);
                                            sc.close();
                                        }else{
                                            System.out.println("Get a msg : " + msg);
                                            SendAndReceiveUtil.sendData(sc,"Server have got you msg:"+ msg);
                                            SocketChannel socketChannel = sc.shutdownOutput();
                                        }
                                    }

                                    it.remove();
                                }

                                //execute((ServerSocketChannel) readyKey.channel());
                            }
                        }
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();
    }

}