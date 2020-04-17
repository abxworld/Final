package com.bsworld.springboot.start.proxy.javassit;
/*
*author: xieziyang
*date: 2018/5/28
*time: 10:46
*description:
*/

public class StationProxy implements TicketService {
    private Station station;

    public StationProxy(Station station) {
        this.station = station;
    }

    @Override
    public void sellTicket() {

        // 1.做真正业务前，提示信息
        this.showAlertInfo("××××您正在使用车票代售点进行购票，每张票将会收取5元手续费！××××");
        // 2.调用真实业务逻辑
        station.sellTicket();
        // 3.后处理
        this.takeHandlingFee();
        this.showAlertInfo("××××欢迎您的光临，再见！××××\n");

    }

    @Override
    public void inquire() {
        // 1做真正业务前，提示信息
        this.showAlertInfo("××××欢迎光临本代售点，问询服务不会收取任何费用，本问询信息仅供参考，具体信息以车站真实数据为准！××××");
        // 2.调用真实逻辑
        station.inquire();
        // 3。后处理
        this.showAlertInfo("××××欢迎您的光临，再见！××××\n");
    }

    @Override
    public void withdraw() {
        // 1。真正业务前处理
        this.showAlertInfo("××××欢迎光临本代售点，退票除了扣除票额的20%外，本代理处额外加收2元手续费！××××");
        // 2.调用真正业务逻辑
        station.withdraw();
        // 3.后处理
        this.takeHandlingFee();

    }

    /*
     * 展示额外信息
     */
    private void showAlertInfo(String info) {
        System.out.println(info);
    }

    /*
     * 收取手续费
     */
    private void takeHandlingFee() {
        System.out.println("收取手续费，打印发票。。。。。\n");
    }
}
