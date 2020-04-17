package com.bsworld.springboot.start.proxy.jdkNew;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-17 15:26
 * description:
 */
public class JdkProxGeneratorUtil {


    public static void main(String[] args) {
        Class userServiceClass = UserServiceImpl.class;
        generateClassFile(userServiceClass, "UserServiceProxy");
    }
    /**
     *
     * @param clazz 必须为实现类的class,不能直接为接口名
     *              比如说不能为UserService.class，而必须为UserServiceImpl.class
     *              否则生成的代理，则不会实现UserService.class
     * */
    public static void generateClassFile(Class clazz, String proxyName) {
        // 根据类信息和提供的代理类名称，生成字节码
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
//        String paths = clazz.getResource(".").getPath();
        String paths = "/Users/xieziyang/projects/Final/springboot/src/main/java/com/bsworld/springboot/start/proxy/jdkNew/";
        System.out.println(paths);
        FileOutputStream out = null;
        try {
            //保留到硬盘中
            out = new FileOutputStream(paths + proxyName + ".class");
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
