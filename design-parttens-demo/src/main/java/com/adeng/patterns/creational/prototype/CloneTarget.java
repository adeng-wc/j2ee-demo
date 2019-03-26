package com.adeng.patterns.creational.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CloneTarget extends Prototype {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
//        return this.deepClone();

    }

    public Object deepClone() {

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            CloneTarget copy = (CloneTarget) ois.readObject();

            return copy;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
}
