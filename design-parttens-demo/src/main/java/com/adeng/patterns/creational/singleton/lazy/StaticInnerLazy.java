package com.adeng.patterns.creational.singleton.lazy;

/**
 * 利用静态内部类延迟加载
 *
 * 利用JVM的类加载达到单例
 */
public class StaticInnerLazy {

    private StaticInnerLazy(){}

    public static StaticInnerLazy getInstance(){
        return InnerClass.INSTANCE;
    }

    private static class InnerClass {
        private static StaticInnerLazy INSTANCE = new StaticInnerLazy();
    }
}
