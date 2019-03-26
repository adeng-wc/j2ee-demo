package com.adeng.patterns.creational.singleton.serializable;


import java.io.*;

/**
 * 单例序列化
 */
public class Serializa implements Serializable {

    public final static Serializa INSTANCE = new Serializa();

    public static Serializa getInstance(){
        return INSTANCE;
    }

    /*
        反序列化的时候回调用该方法 readResolveMethod
     */
    private Object readResolve(){
        return INSTANCE;
    }


    public static void main(String[] args) throws Exception {

        Serializa s = Serializa.getInstance();

        //序列化
        OutputStream os = new FileOutputStream("Serializa.obj");
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(s);
        oos.flush();

        //反序列化
        InputStream is = new FileInputStream("Serializa.obj");
        ObjectInputStream ois = new ObjectInputStream(is);
        Serializa s2 = (Serializa) ois.readObject();

        /*
            正常情况，序列化和反序列化出来的是不一样的。
            但是如果对象实现了 readResolve()方法
         */
        System.out.println(s == s2);


        is.close();
        os.close();

    }
}
