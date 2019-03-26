package com.adeng.patterns.creational.factory.simplefactory;

import com.adeng.patterns.creational.factory.BMWCar;
import com.adeng.patterns.creational.factory.Car;
import com.adeng.patterns.creational.factory.QQCar;

/**
 * 简单工厂模式
 */
public class SimpleFactory {

    /**
     * 静态工厂方法
     *
     * @param carName
     * @return
     */
    public static Car make(String carName) {
        switch (carName) {
            case "QQ":
                return new QQCar();
            case "BMW":
                return new BMWCar();
            default:
                throw new IllegalArgumentException("Illegal " + carName);
        }
    }

    public static void main(String[] args) {
        SimpleFactory.make("BMW").drive();
        SimpleFactory.make("QQ").drive();
    }
}
