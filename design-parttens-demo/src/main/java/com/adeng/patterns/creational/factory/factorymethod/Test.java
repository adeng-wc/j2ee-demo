package com.adeng.patterns.creational.factory.factorymethod;

import com.adeng.patterns.creational.factory.Car;

/**
 * @author hzwengcheng 2019-03-26 21:11
 */
public class Test {

    public static void main(String[] args) {
        Car bmw = new BMWFactory().make();
        bmw.drive();
        Car qq = new QQFactory().make();
        qq.drive();
    }
}
