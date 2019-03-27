package com.adeng.patterns.structural.proxy.custom;

import com.adeng.patterns.structural.proxy.Dog;
import com.adeng.patterns.structural.proxy.jdk.HaShiQi;

/**
 * @author hzwengcheng 2019-03-27 15:01
 */
public class Test {


    public static void main(String[] args) {
        try {
            //JDK动态代理的实现原理
            Dog obj = (Dog) new MyJDKProxy().getInstance(new HaShiQi());
            System.out.println(obj.getClass());
            obj.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
