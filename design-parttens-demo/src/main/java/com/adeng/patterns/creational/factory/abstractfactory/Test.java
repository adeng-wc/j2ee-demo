package com.adeng.patterns.creational.factory.abstractfactory;

public class Test {

    public static void main(String[] args) {
        CarFactory bmw = new BMWConcreteFactory();
        CarFactory qq = new QQConcreteFactory();

        bmw.make().drive();
        qq.make().drive();
    }
}
