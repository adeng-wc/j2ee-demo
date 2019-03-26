package com.adeng.patterns.creational.factory.abstractfactory;

import com.adeng.patterns.creational.factory.Car;

/**
 * 抽象工厂类。
 * <p>
 * 定义工厂接口，可以有多个定义多个产品。
 */
public interface CarFactory {

    /**
     * 生成 汽车
     *
     * @return
     */
    Car make();
}
