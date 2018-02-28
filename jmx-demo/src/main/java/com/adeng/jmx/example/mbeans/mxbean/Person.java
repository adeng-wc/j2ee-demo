package com.adeng.jmx.example.mbeans.mxbean;

/**
 * @Author: Adengdeng
 * @Date: Create in 下午9:16 2018
 */
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
