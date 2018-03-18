package com.adeng.designpatterns.creational.factory.abst;

import com.adeng.designpatterns.creational.factory.BMWCar;
import com.adeng.designpatterns.creational.factory.Car;
import com.adeng.designpatterns.creational.factory.QQCar;

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
