package com.adeng.patterns.creational.factory.factorymethod;

import com.adeng.patterns.creational.factory.Car;
import com.adeng.patterns.creational.factory.QQCar;

/**
 * @author hzwengcheng
 */
public class QQFactory implements Factory {

    @Override
    public Car make() {
        return new QQCar();
    }
}
