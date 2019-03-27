package com.adeng.patterns.creational.singleton.lazy;

/**
 * 使用 double check 懒加载
 *
 * @author hzwengcheng 2019-03-27 10:17
 */
public class DoubleCheckLazy {

    public volatile static DoubleCheckLazy OBJ;

    private DoubleCheckLazy() {
    }

    public static DoubleCheckLazy getInstance() {
        if (OBJ == null) {
            // 只有一个线程能拿到锁并初始化
            synchronized (DoubleCheckLazy.class) {
                // 避免一个线程初始化完成后，另一个线程继续初始化（使用 volatile 配合获取数据）
                if (OBJ == null) {
                    OBJ = new DoubleCheckLazy();
                }
            }
        }

        return OBJ;
    }
}
