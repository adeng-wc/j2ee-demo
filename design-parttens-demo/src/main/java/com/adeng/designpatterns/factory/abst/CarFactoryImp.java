package com.adeng.designpatterns.factory.abst;

import com.adeng.designpatterns.factory.BMWCar;
import com.adeng.designpatterns.factory.Car;
import com.adeng.designpatterns.factory.QQCar;

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
