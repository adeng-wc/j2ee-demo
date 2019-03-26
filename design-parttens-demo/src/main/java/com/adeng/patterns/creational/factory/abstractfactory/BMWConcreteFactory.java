package com.adeng.patterns.creational.factory.abstractfactory;

import com.adeng.patterns.creational.factory.BMWCar;
import com.adeng.patterns.creational.factory.Car;

/**
 * BMW 工厂
 */
public class BMWConcreteFactory  {

    public Car mack() {
        return new BMWCar();
    }
}
