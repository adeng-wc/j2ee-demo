package com.adeng.designpatterns.creational.singleton.registered;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册模式将类对象加载Map中
 */
public class RegisterMap {

    private RegisterMap(){}

    private static Map<String,Object> register = new ConcurrentHashMap<>();

    public static RegisterMap getInstance(String name){
        if(name == null) {
            name = RegisterMap.class.getName();
        }

        if(register.get(name) == null){
            register.put(name, new RegisterMap());
        }

        return (RegisterMap) register.get(name);
    }
}
