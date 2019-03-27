package com.adeng.patterns.creational.prototype;

import java.io.Serializable;

/**
 * 继承 原型类
 * <p>
 * 课程类
 */
public class Course implements Cloneable, Serializable {

    String name;

    public Course(String name) {
        this.name = name;
    }
}
