package com.adeng.demo.jmx.standard;

/**
 * JMX标准类型
 * Created by w11282 on 2018/1/25.
 */
public interface CarMBean {

    public String getColor();

    public void setColor(String s);

    public void drive();

    public void reset();

    public void helloWorld(String s);
}

