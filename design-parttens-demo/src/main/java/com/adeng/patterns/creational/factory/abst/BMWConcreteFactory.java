package com.adeng.patterns.creational.factory.abst;

import com.adeng.patterns.creational.factory.BMWCar;
import com.adeng.patterns.creational.factory.Car;

public class BMWConcreteFactory  {


    public Car mack() {

        return new BMWCar();
    }
}
