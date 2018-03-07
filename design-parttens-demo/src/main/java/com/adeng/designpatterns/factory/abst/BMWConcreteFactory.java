package com.adeng.designpatterns.factory.abst;

import com.adeng.designpatterns.factory.BMWCar;
import com.adeng.designpatterns.factory.Car;

public class BMWConcreteFactory  {


    public Car mack() {

        return new BMWCar();
    }
}
