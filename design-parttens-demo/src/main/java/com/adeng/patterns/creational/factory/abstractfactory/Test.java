package com.adeng.patterns.creational.factory.abstractfactory;

public class Test {

    public static void main(String[] args) {
        CarFactory factory = new CarFactoryImp();
        factory.mackQQ().drive();
        factory.mackBMW().drive();
    }
}
