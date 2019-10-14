package com.bsworld.springboot.start.LocalDate;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2018-12-12 12:21
 * description:
 */
public class EnumMain {
    public static void main(String[] args) {
        ColorType type = getType();
        System.out.println(type);
        switch (type) {
            case RED:
                System.out.println("red,key");
            case GREEN:
                System.out.println("green key");
                break;
            case BULE:
                System.out.println("blue key");
                break;
            default:
                System.out.println("def");
        }
    }

    private static ColorType getType() {
        return ColorType.RED;
    }
}