package com.adeng.designpatterns.factory.abst;

import com.adeng.designpatterns.factory.Car;
import com.adeng.designpatterns.factory.QQCar;

public class QQConcreteFactory  {

    public Car mack() {
        return new QQCar();
    }
}
