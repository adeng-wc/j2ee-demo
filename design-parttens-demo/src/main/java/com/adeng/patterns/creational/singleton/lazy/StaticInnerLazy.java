package com.adeng.patterns.creational.singleton.lazy;

/**
 * 利用静态内部类延迟加载。3中懒加载中，性能最好。JVM的加载，没有使用锁。
 *
 * 利用JVM的类加载达到单例
 */
public class StaticInnerLazy {

    private StaticInnerLazy(){}

    /**
     * getInstance 方法被调用的时候，JVM才会加载 内部类 {@link InnerClass}, 类加载过程中是 synchronized 的
     *
     * @return
     */
    public static StaticInnerLazy getInstance(){
        return InnerClass.INSTANCE;
    }

    private static class InnerClass {
        private static StaticInnerLazy INSTANCE = new StaticInnerLazy();
    }
}
