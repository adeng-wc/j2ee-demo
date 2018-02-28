package com.adeng.jmx.example.mbeans.standard;

/**
 * @Author: Adengdeng
 * @Date: Create in 下午8:25 2018
 */
public interface HelloMBean {

    public void sayHello();

    public int add(int x, int y);

    public String getName();

    public int getCacheSize();

    /* 有设置接口，所以可以直接在JConsole上修改CacheSize */
    public void setCacheSize(int size);
}
