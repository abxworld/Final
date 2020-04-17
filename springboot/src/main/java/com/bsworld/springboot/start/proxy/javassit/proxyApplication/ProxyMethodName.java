package com.bsworld.springboot.start.proxy.javassit.proxyApplication;
/*
*author: xieziyang
*date: 2018/5/28
*time: 14:23
*description:
*/


import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.javassist.NotFoundException;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.apache.ibatis.javassist.bytecode.LocalVariableAttribute;
import org.apache.ibatis.javassist.bytecode.MethodInfo;

public class ProxyMethodName {
    public static void main(String[] args) {
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass proxy = pool.get("com.proxy.Station");
            CtMethod hello = proxy.getDeclaredMethod("hello");
            MethodInfo methodInfo = hello.getMethodInfo();
            CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
            LocalVariableAttribute attribute = (LocalVariableAttribute )codeAttribute.getAttribute(LocalVariableAttribute.tag);
            for (int i = 0; i < hello.getParameterTypes().length; i++) {
                String name = attribute.variableName(i);
                System.out.println(name);
            }

        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}
