package com.adeng.patterns.creational.factory.simplefactory;

import com.adeng.patterns.creational.factory.BMWCar;
import com.adeng.patterns.creational.factory.Car;
import com.adeng.patterns.creational.factory.QQCar;

/**
 * 简单工厂模式
 */
public class SimpleFactory {

    /**
     * 静态工厂方法
     *
     * @return
     */
    public static Car make(Class<? extends Car> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        SimpleFactory.make(BMWCar.class).drive();
        SimpleFactory.make(QQCar.class).drive();
    }
}
