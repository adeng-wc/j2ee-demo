package com.adeng.jmx.example.mbeans.mxbean;

import javax.management.MXBean;

/**
 * 使用注解方式，不用以MXBean结尾
 * <p>
 * 不支持使用泛型 T
 *
 * @Author: Adengdeng
 * @Date: Create in 下午8:56 2018
 */
@MXBean(true)
public interface BaseController {

    public void sayHello();

    public int getMapSize();

    public void add(String name);

    public Person get(String name);
}
