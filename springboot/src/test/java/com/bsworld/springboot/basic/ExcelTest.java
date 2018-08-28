package com.bsworld.springboot.basic;
/*
*author: xieziyang
*date: 2018/8/17
*time: 10:30
*description:
*/

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ExcelTest {
    @Test
    public void run1() {
        String path = "C:\\Users\\bsworld\\Desktop\\FK_REQ_20180802_001.xlsx";
        File file = new File(path);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            fis.close();
            List<MerTransferModel> tTransferOrders = ExcelUtil.parse0(bytes);
            System.out.println(JSON.toJSONString(tTransferOrders));
            System.out.println(tTransferOrders.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
