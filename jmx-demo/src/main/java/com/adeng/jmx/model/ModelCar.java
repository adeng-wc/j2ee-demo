package com.adeng.jmx.model;

/**
 * JMX 模板类型
 * <p>
 * Created by w11282 on 2018/1/25.
 */
public class ModelCar {

    private String color = "red";

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void drive() {
        System.out.println("Body you can drive my " + color + " car.");
    }
}
