package com.adeng.designpatterns.creational.factory.abst;

import com.adeng.designpatterns.creational.factory.Car;
import com.adeng.designpatterns.creational.factory.QQCar;

public class QQConcreteFactory  {

    public Car mack() {
        return new QQCar();
    }
}
