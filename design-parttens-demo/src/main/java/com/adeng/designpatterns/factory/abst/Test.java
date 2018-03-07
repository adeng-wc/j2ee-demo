package com.adeng.designpatterns.factory.abst;

public class Test {


    public static void main(String[] args) {

        AbstractFactory factory = new CarFactoryImp();

        factory.mackQQ().drive();
        factory.mackBMW().drive();

    }
}
