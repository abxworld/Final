package com.bsworld.springboot.start.proxy;
/*
*author: xieziyang
*date: 2018/5/28
*time: 10:44
*description:
*/

import org.apache.ibatis.javassist.*;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ProxyCreate {
    public static void main(String[] args) throws IOException, CannotCompileException, NotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        createProxy();
    }

    public static void createProxy() throws CannotCompileException, NotFoundException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassPool pool = ClassPool.getDefault();
        CtClass proxy = pool.makeClass("com.proxy.TicketProxy");
        CtField station = CtField.make("private com.proxy.Station station;", proxy);
        proxy.addField(station);
        CtClass interFace = pool.get("com.proxy.TicketService");
        proxy.addInterface(interFace);

        CtClass stationClass = pool.get("com.proxy.Station");
        CtClass[] arrays = new CtClass[]{stationClass};
       // CtConstructor constructor = CtNewConstructor.make(arrays, null, proxy);
        CtConstructor ctConstructor = new CtConstructor(arrays,proxy);
        ctConstructor.setBody("this.station = $1;");
        proxy.addConstructor(ctConstructor);

        //创建收取手续 takeHandlingFee方法
        CtMethod takeHandlingFee = CtMethod.make("private void takeHandlingFee() {}", proxy);
        takeHandlingFee.setBody("System.out.println(\"收取手续费，打印发票。。。。。\");");
        proxy.addMethod(takeHandlingFee);

        CtMethod showAlertInfo = CtMethod.make("private void showAlertInfo(String info) {}", proxy);
        showAlertInfo.setBody("System.out.println($1);");
        proxy.addMethod(showAlertInfo);

        CtMethod sellTicket = CtMethod.make("public void sellTicket() {}", proxy);
        sellTicket.setBody("{this.showAlertInfo(\"××××您正在使用车票代售点进行购票，每张票将会收取5元手续费！××××\");"
                + "station.sellTicket();"
                + "this.takeHandlingFee();"
                + "this.showAlertInfo(\"××××欢迎您的光临，再见！××××\");}");
        proxy.addMethod(sellTicket);

        CtMethod inquire = CtMethod.make("public void inquire() {}", proxy);
        inquire.setBody("{this.showAlertInfo(\"××××欢迎光临本代售点，问询服务不会收取任何费用，本问询信息仅供参考，具体信息以车站真实数据为准！××××\");"
                + "station.inquire();"
                + "this.showAlertInfo(\"××××欢迎您的光临，再见！××××\");}"
        );
        proxy.addMethod(inquire);

        //添加widthraw方法
        CtMethod withdraw = CtMethod.make("public void withdraw() {}", proxy);
        withdraw.setBody("{this.showAlertInfo(\"××××欢迎光临本代售点，退票除了扣除票额的20%外，本代理处额外加收2元手续费！××××\");"
                + "station.withdraw();"
                + "this.takeHandlingFee();}"
        );

        proxy.addMethod(withdraw);
        Class proxyClass = proxy.toClass();
        Constructor constructor0 = proxyClass.getConstructor(Station.class);
        TicketService ticketService = (TicketService) constructor0.newInstance(new Station());
        ticketService.inquire();
        proxy.writeFile("C:\\Users\\bsworld\\Netty\\CONCURRENT\\src\\main\\java\\com\\proxy");
    }
}
