package com.adeng.patterns.creational.singleton.registered;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册模式将类对象加载Map中
 */
public class RegisterMap {

    private RegisterMap() {
    }

    private static Map<String, Object> register = new ConcurrentHashMap<>();

    public static RegisterMap getInstance(String name) {
        if (name == null) {
            name = RegisterMap.class.getName();
        }

        // ConcurrentHashMap 只能保证 put 是线程安全的。 get 和 put 的组合不能保证，所以需要用锁来保证
        synchronized (register) {
            if (register.get(name) == null) {
                register.put(name, new RegisterMap());
            }
        }

        return (RegisterMap) register.get(name);
    }
}
