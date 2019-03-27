package com.adeng.patterns.structural.proxy.jdk;

import com.adeng.patterns.structural.proxy.Dog;

/**
 * JDK Proxy 需要代理对象实现接口
 */
public class HaShiQi implements Dog {
    @Override
    public String run() {
        System.out.println("哈士奇 run");
        return "return 哈士奇 run";
    }
}
