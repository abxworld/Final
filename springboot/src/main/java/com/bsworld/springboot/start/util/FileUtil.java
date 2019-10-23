package com.bsworld.springboot.start.util;

import com.bsworld.springboot.start.circle.B;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-10-23 11:38
 * description:
 */
public class FileUtil {
    public static String getRemoteHost()  {
        return getValue("remote_host");
    }

    public static String getRemotePort() {
        return getValue("remote_port");
    }

    public static String getRemoteUserName() {
        return getValue("remote_user_name");
    }

    public static String getRemoteUPassWord(){
        return getValue("remote_pass_word");
    }


    private static String getValue(String key) {
        InputStream os = null;
        try {
            os = Runtime.getRuntime().exec("grep "+key+" remote.secret").getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(os));
            String res = "";
            String a = br.readLine();
            while (a != "" && a != null) {
                res = res + a;
                a = br.readLine();
            }
            br.close();
            String[] split = res.split("=");
            return split[1];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
