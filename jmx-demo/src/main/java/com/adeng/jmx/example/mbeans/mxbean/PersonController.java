package com.adeng.jmx.example.mbeans.mxbean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Adengdeng
 * @Date: Create in 下午8:58 2018
 */
public class PersonController implements BaseController {

    private Map<String, Person> map = new ConcurrentHashMap<>();


    @Override
    public void sayHello() {
        System.out.println("Hello MXBean!");
    }

    @Override
    public int getMapSize() {
        return map.size();
    }

    @Override
    public void add(String name) {
        map.put(name, new Person(name));
    }

    @Override
    public Person get(String name) {
        return map.get(name);
    }

}
