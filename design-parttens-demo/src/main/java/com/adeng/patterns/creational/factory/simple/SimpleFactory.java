package com.adeng.patterns.creational.factory.simple;

import com.adeng.patterns.creational.factory.BMWCar;
import com.adeng.patterns.creational.factory.Car;
import com.adeng.patterns.creational.factory.QQCar;

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
