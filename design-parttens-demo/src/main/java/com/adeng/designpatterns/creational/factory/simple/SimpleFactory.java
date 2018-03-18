package com.adeng.designpatterns.creational.factory.simple;

import com.adeng.designpatterns.creational.factory.BMWCar;
import com.adeng.designpatterns.creational.factory.Car;
import com.adeng.designpatterns.creational.factory.QQCar;

public class SimpleFactory {

    public Car make(String carName){

        switch (carName){
            case "QQ":
                return  new QQCar();
            case "BMW":
                return new BMWCar();

        }

        return null;
    }

    public static void main(String[] args) {

        new SimpleFactory().make("BMW").drive();
        new SimpleFactory().make("QQ").drive();

    }

}
