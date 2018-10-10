package com.bsworld.springboot.start.nio.socket.bio;
/*
*author: xieziyang
*date: 2018/9/28
*time: 17:16
*description:
*/

import java.io.*;

public class FileRead {
    public static void main(String[] args) {
        File file = new File("D:\\t_mer对比文档.txt");
        String prefix = "ALTER TABLE `t_mer` ADD COLUMN ";
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis,"GBK");
            BufferedReader reader = new BufferedReader(isr);
            String readLine = reader.readLine();
            while (readLine != null) {
                System.out.println(prefix + readLine);
                readLine = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
