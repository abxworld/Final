package com.bsworld.springboot.start.nio.serialize;

import com.alibaba.fastjson.JSON;
import com.bsworld.springboot.basic.MyBean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * program: fianl
 * author: bsworld.xie
 * create: 2020-01-02 17:58
 * description:
 */
public class PrimiteSerialize {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "/Users/xieziyang/projects/Final/Final/springboot/src/test/java/com/bsworld/springboot/start/nio/serialize/private.txt";
        File file = new File(fileName);
        boolean exists = file.exists();
        if (!exists) {
            boolean newFile = file.createNewFile();
            System.out.println(newFile);
        }

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));


        oos.writeObject(new MyBean("hello", 100l));

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));

        Object readObject = ois.readObject();
        System.out.println(JSON.toJSONString(readObject));

    }



}
