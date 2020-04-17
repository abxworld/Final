package com.bsworld.springboot.start.proxy.jdkNew;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2020-04-17 15:28
 * description:
 * 主方法
 */
public class JdkProxyMain {

    public static void main(String[] args) {
        UserService proxyService = create();
        proxyService.add("hello world");

    }

    /**
     * 生成jdk动态代理步骤如下
     *
     *1、创建被代理的对象
     *
     *2、将代理对象作为参数传入InvocationHandler的实现中
     *
     * 3、生成动态代理类 {@link UserServiceProxy}
     *
     *注:如果想要自己手动生成动态代理,参考{@link JdkProxGeneratorUtil},示例参考{"UserServiceProxy.class",但是很多代码被编译了}
     * */
    public static UserService create() {
        UserService userService = new UserServiceImpl();
        UserService proxyService = (UserService) Proxy.newProxyInstance(JdkProxyMain.class.getClassLoader()
                , new Class[]{UserService.class}
                , new InvocationHandlerImpl(userService));


        return proxyService;
    }
    /**
     * 以{@link UserService#add(String)}为例来描述代理调用的流程
     *
     * 具体代码参考{@link UserServiceProxy#add(String)}
     *
     * 1、获取父类的{@link InvocationHandlerImpl}
     *
     * 2、通过反射调用相关指定的方法，并传入参数
     *
     * 3、执行 {@link InvocationHandlerImpl#invoke(Object, Method, Object[])}
     *
     * 4、在{@link InvocationHandlerImpl#invoke(Object, Method, Object[])}里可以执行相关的动态逻辑
     *
     *    example:执行具体调用前后打印相关的日志
     *
     * 5、返回执行结果
     *@return Object
     *
     *
     * */
    public static void invokeAdd(UserService proxyService, String something) {

        proxyService.add(something);

    }
}
