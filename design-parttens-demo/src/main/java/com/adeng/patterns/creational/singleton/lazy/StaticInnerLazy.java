package com.adeng.patterns.creational.singleton.lazy;

/**
 * 利用静态内部类延迟加载。3中懒加载中，性能最好。JVM的加载，没有使用锁。
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
