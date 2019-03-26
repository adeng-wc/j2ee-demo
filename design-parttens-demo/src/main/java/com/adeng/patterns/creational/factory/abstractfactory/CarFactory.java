package com.adeng.patterns.creational.factory.abstractfactory;

import com.adeng.patterns.creational.factory.Car;

/**
 * 抽象工厂类
 */
public interface CarFactory {

    /**
     * 生成 汽车
     *
     * @return
     */
    Car make();
}
