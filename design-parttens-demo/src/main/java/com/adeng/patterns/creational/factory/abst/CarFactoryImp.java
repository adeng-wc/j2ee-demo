package com.adeng.patterns.creational.factory.abst;

import com.adeng.patterns.creational.factory.BMWCar;
import com.adeng.patterns.creational.factory.Car;
import com.adeng.patterns.creational.factory.QQCar;

public class CarFactoryImp extends AbstractFactory{

    @Override
    public Car mackBMW() {
        return new BMWCar();
    }

    @Override
    public Car mackQQ() {
        return new QQCar();
    }
}
