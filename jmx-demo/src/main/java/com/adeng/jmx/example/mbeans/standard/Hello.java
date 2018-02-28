package com.adeng.jmx.example.mbeans.standard;

/**
 * @Author: Adengdeng
 * @Date: Create in 下午8:27 2018
 */
public class Hello implements HelloMBean{

    private String name = "HelloName";
    private int cacheSize = 100;

    public void sayHello() {
        System.out.println("Hello, world!");
    }

    public int add(int x, int y) {
        return x + y;
    }

    public String getName() {
        return name;
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int size) {
        cacheSize = size;
    }
}
