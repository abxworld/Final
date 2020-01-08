package com.bsworld.springboot.start.nio.serialize;

import com.alibaba.fastjson.JSON;
import com.bsworld.springboot.basic.MyBean;
import org.apache.jute.BinaryInputArchive;
import org.apache.jute.BinaryOutputArchive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * program: fianl
 * author: bsworld.xie
 * create: 2020-01-02 17:04
 * description:
 */
public class JuintSerializeMainTest {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/xieziyang/projects/Final/Final/springboot/src/test/java/com/bsworld/springboot/start/nio/serialize/qp.txt";
        File file = new File(fileName);
        boolean exists = file.exists();
        if (!exists) {
            boolean newFile = file.createNewFile();
            System.out.println(newFile);
        }
        OutputStream os = new FileOutputStream(file);

//        DataOutputStream oos = new DataOutputStream(os);

        MyBean writeBean = new MyBean("hello", 100l);


        BinaryOutputArchive boa = BinaryOutputArchive.getArchive(os);
        boa.writeInt(-1, "intc");
//        boa.writeBool(true, "booleanc");
//        boa.writeInt(-1,"len");
        writeBean.serialize(boa, "request");


        System.out.println(JSON.toJSONString(writeBean));

        BinaryInputArchive bia = BinaryInputArchive.getArchive(new FileInputStream(fileName));

        MyBean readBean = new MyBean();

        readBean.deserialize(bia, "request");

        System.out.println(JSON.toJSONString(readBean));


//        BinaryInputArchive archive = BinaryInputArchive.getArchive(new FileInputStream(new File(fileName)));
//        archive.readRecord();
    }
}
