package com.adeng.patterns.creational.singleton.lazy;

/**
 * 使用 Synchronized 懒加载
 *
 * @author hzwengcheng 2019-03-27 10:17
 */
public class SynchronizedLazy {

    public static SynchronizedLazy OBJ;

    private SynchronizedLazy() {
    }

    public synchronized static SynchronizedLazy getInstance() {
        if (OBJ == null) {
            OBJ = new SynchronizedLazy();
        }
        return OBJ;
    }

}
