package com.adeng.jmx.standard;


/**
 * JMX标准类型
 *
 * Created by w11282 on 2018/1/25.
 */
public class Car implements CarMBean {

    private String color = "red";

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        System.out.println("setColor: "+ color);
    }

    public void drive(){
        System.out.println("Body you can drive my " + color + " car.");
    }

    public void reset() {
        color = "reset red";
        System.out.println("reset: "+ color);
    }

    public void helloWorld(String s) {
        System.out.println("helloWorld:"+ s);
    }
}

