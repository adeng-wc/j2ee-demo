package com.adeng.designpatterns.creational.factory.abst;

import com.adeng.designpatterns.creational.factory.BMWCar;
import com.adeng.designpatterns.creational.factory.Car;

public class BMWConcreteFactory  {


    public Car mack() {

        return new BMWCar();
    }
}
