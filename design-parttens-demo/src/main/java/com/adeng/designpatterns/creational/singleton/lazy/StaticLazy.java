package com.adeng.designpatterns.creational.singleton.lazy;

/**
 * 利用静态内部类延迟加载
 *
 * 利用JVM的类加载达到单例
 */
public class StaticLazy {

    private StaticLazy(){}

    public static StaticLazy getInstance(){
        return innerClass.INSTANCE;
    }

    private static class innerClass{
        private static StaticLazy INSTANCE = new StaticLazy();
    }
}
