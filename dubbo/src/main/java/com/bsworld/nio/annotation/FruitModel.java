package com.bsworld.nio.annotation;
/*
*author: xieziyang
*date: 2018/5/12
*time: 19:09
*description:
*/
public class FruitModel {
    @FruitName("orange")
    private String name;

    @FruitColor(fruitColor = FruitColor.Color.GREEN)
    private String colorName;

    @FruitProvider(id = 1,name = "red fuShi",address = "shanXi province")
    private String provider;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FruitModel{" +
                "name='" + name + '\'' +
                ", colorName='" + colorName + '\'' +
                ", provider='" + provider + '\'' +
                '}';
    }
}
