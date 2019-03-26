package com.adeng.patterns.creational.factory.abstractfactory;

import com.adeng.patterns.creational.factory.Car;
import com.adeng.patterns.creational.factory.QQCar;

/**
 * QQ 工厂
 */
public class QQConcreteFactory implements CarFactory {
    @Override
    public Car make() {
        return new QQCar();
    }
}
