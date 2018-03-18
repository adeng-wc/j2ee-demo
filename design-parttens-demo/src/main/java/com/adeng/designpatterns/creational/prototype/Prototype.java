package com.adeng.designpatterns.creational.prototype;

import java.io.*;

public class Prototype implements Cloneable, Serializable{

    public String name;

    CloneTarget target = null;

    public static void main(String[] args) throws CloneNotSupportedException {

        CloneTarget p = new CloneTarget();
        p.name = "123";
        p.target = new CloneTarget();

        CloneTarget clone = (CloneTarget) p.clone();

        /*
            调用深克隆，引用类型的内存地址都不同了
         */
        System.out.println(clone == p);
        System.out.println(clone.name == p.name);
        System.out.println(clone.target == p.target);

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();

    }

    public Object deepClone() {

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            Prototype copy = (Prototype) ois.readObject();

            return copy;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
}
