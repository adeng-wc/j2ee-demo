package com.adeng.patterns.creational.prototype;

import java.io.*;
import java.util.List;

/**
 * 原型模式，浅克隆和深克隆
 * <p>
 * 学生类报名课程
 */
public class StudentPrototype implements Cloneable, Serializable {

    String name;
    String number;
    int age;

    List<Course> courses;

    /**
     * 使用 深克隆 重写了 clone 方法
     *
     * @return
     */
    @Override
    protected StudentPrototype clone() throws CloneNotSupportedException {
        return (StudentPrototype) this.deepClone();
//        return (StudentPrototype) super.clone();

    }

    /**
     * 通过序列化实现深克隆
     *
     * @return
     */
    public Object deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
