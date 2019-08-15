package com.bsworld.springboot.generic;

import com.alibaba.druid.util.StringUtils;
import org.junit.Test;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-07-22 18:05
 * description:
 */
public class ChangeParamTest {
   @Test
    public void run() {
        hello(1,1,34);
   }

   public <K> void hello(K... k) {
       for (K k1 : k) {
           System.out.println(k1);
       }
   }
    public static void main(String[] args) {
        String backPic = "http://www.baidu.com/hello.png";
        if (!StringUtils.isEmpty(backPic)) {
            if (backPic.startsWith("http")) {
                int i = backPic.lastIndexOf("/");
                if (i != -1) {
                    backPic = backPic.substring(i+1);
                }
            }
            System.out.println(backPic);
        }
    }
}
