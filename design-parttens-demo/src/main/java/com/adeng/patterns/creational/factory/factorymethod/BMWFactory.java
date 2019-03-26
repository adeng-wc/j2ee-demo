package com.adeng.patterns.creational.factory.factorymethod;

import com.adeng.patterns.creational.factory.BMWCar;
import com.adeng.patterns.creational.factory.Car;

/**
 * @author hzwengcheng
 */
public class BMWFactory implements Factory {

    @Override
    public Car make() {
        return new BMWCar();
    }
}
