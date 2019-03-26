package com.adeng.patterns.creational.factory.abstractfactory;

import com.adeng.patterns.creational.factory.BMWCar;
import com.adeng.patterns.creational.factory.Car;
import com.adeng.patterns.creational.factory.QQCar;

/**
 * 抽象工厂实现类
 *
 * @author hzwengcheng
 */
public class CarFactoryImp implements CarFactory {

    @Override
    public Car mackBMW() {
        return new BMWCar();
    }

    @Override
    public Car mackQQ() {
        return new QQCar();
    }
}
