package com.bsworld.springboot.start.proxy;
/*
*author: xieziyang
*date: 2018/5/28
*time: 10:42
*description:
*/

public class Station implements TicketService {
    @Override
    public void sellTicket() {
        System.out.println("\n\t售票.....\n");
    }

    @Override
    public void inquire() {
        System.out.println("\n\t问询。。。。\n");
    }

    @Override
    public void withdraw() {
        System.out.println("\n\t退票......\n");
    }

    public static void hello(String name, String java) {
        System.out.println(name);
        System.out.println(java);
    }
}
