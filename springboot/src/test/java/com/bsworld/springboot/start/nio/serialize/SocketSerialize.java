package com.bsworld.springboot.start.nio.serialize;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * program: fianl
 * author: bsworld.xie
 * create: 2020-01-02 18:02
 * description:
 */
public class SocketSerialize {


    public static void main(String[] args) {


    }


    static class ServerSockMain {

        private static Map<Long, Socket> socketMap = new HashMap<>();

        private static ArrayBlockingQueue<Socket> sockets = new ArrayBlockingQueue<>(100);


        private static Map<Long, List<SocketToBean>> tempSocketMsgMap = new ConcurrentHashMap<>();

        public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = new ServerSocket(8888);
            new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("准备接收链接");
                        Socket sc = serverSocket.accept();
                        sockets.add(sc);
                        System.out.println("收到链接，socket:" + JSON.toJSONString(sc));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                while (true) {
                    Socket sc = null;
                    try {
                        sc = sockets.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Socket fSc = sc;
                    new Thread(() -> {
                        try {
                            while (true) {
                                InputStream inputStream = fSc.getInputStream();
                                ObjectInputStream ois = new ObjectInputStream(inputStream);
                                Object readObject = ois.readObject();
                                SocketFromBean socketFromBean = (SocketFromBean) readObject;
                                System.out.println("接收消息， fromBean:" + JSON.toJSONString(socketFromBean));
                                if (socketFromBean == null) {
                                    continue;
                                }
                                if ("connect".equals(socketFromBean.getMessage())) {
                                    Long id = socketFromBean.getFromId();
                                    socketMap.put(id, fSc);
                                    continue;
                                }
                                Long transferId = socketFromBean.getToId();
                                if (transferId == null) {
                                    continue;
                                }
                                SocketToBean socketToBean = new SocketToBean();
                                BeanUtils.copyProperties(socketFromBean, socketToBean);
                                Socket transferSc = socketMap.get(transferId);
                                if (transferSc == null) {
                                    List<SocketToBean> socketToBeans = tempSocketMsgMap.get(transferId);
                                    if (socketToBeans == null) {
                                        socketToBeans = new ArrayList<>();
                                        tempSocketMsgMap.put(transferId, socketToBeans);
                                    }
                                    socketToBeans.add(socketToBean);
                                    continue;
                                }
                                writeToBean(transferSc, socketToBean);

                            }
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            }).start();

            new Thread(() -> {
                while (true) {
                    for (Map.Entry<Long, List<SocketToBean>> entry : tempSocketMsgMap.entrySet()) {
                        System.out.println("tempSocketMsgMap, circle, entry:" + JSON.toJSONString(entry));
                        Long key = entry.getKey();
                        Socket socket = socketMap.get(key);
                        if (socket == null) {
                            System.out.println("睡眠三秒");
                            try {
                                Thread.sleep(3000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            continue;
                        }
                        List<SocketToBean> socketToBeanList = entry.getValue();

                        Iterator<SocketToBean> iterator = socketToBeanList.iterator();
                        while (iterator.hasNext()) {
                            {
                                try {
                                    writeToBean(socket, iterator.next());
                                    iterator.remove();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }


                }
            }).start();

            System.in.read();
        }
    }

    static class SocketMain0 {
        public static void main(String[] args) throws IOException, InterruptedException {
            Socket socket = new Socket("127.0.0.1", 8888);
            socket.setTcpNoDelay(true);
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(new SocketFromBean(1l, "connect"));
            int i = 0;
            while (true) {
                outputStream = socket.getOutputStream();
                oos = new ObjectOutputStream(outputStream);
                oos.writeObject(new SocketFromBean(1l, "hello world" + i++, 2l));
                oos.flush();
                System.out.println("end:" + JSON.toJSONString(oos));
                Thread.sleep(1000);
            }
        }

    }


    static class SocketMain1 {
        public static void main(String[] args) throws IOException {
            Socket socket = new Socket("localhost", 8888);
            socket.setTcpNoDelay(true);
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(new SocketFromBean(2l, "connect"));

            while (true) {
                InputStream inputStream = null;
                try {
                    inputStream = socket.getInputStream();
                    ObjectInputStream ois = new ObjectInputStream(inputStream);
                    Object readObject = ois.readObject();
                    System.out.println(JSON.toJSONString(readObject));
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    private static void writeToBean(Socket socket, SocketToBean toBean) throws IOException {
        System.out.println(JSON.toJSONString(toBean));
        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        System.out.println("发送消息， socketToBean:" + JSON.toJSONString(toBean));
        oos.writeObject(toBean);
        oos.flush();
    }

}
