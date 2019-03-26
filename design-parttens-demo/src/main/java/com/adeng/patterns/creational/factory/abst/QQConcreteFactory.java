package com.adeng.patterns.creational.factory.abst;

import com.adeng.patterns.creational.factory.Car;
import com.adeng.patterns.creational.factory.QQCar;

public class QQConcreteFactory  {

    public Car mack() {
        return new QQCar();
    }
}
