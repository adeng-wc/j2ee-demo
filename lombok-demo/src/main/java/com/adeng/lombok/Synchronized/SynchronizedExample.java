package com.adeng.lombok.Synchronized;

import lombok.Synchronized;

/**
 * 关键字锁定this，但注释锁定名为的字段$lock，这是私人的。
 *  也就是说每个 @Synchronized 都会生成一个锁对象。
 *
 * 指定锁对象的时候锁，锁对象必须存在
 *
 * @author
 * @create 2018-04-21 23:29
 */
public class SynchronizedExample {


    private final Object readLock = new Object();

    @Synchronized
    public static void hello() {
        System.out.println("world");
    }

    @Synchronized
    public int answerToLife() {
        return 42;
    }

    @Synchronized("readLock")
    public void foo() {
        System.out.println("bar");
    }


    public static void main(String[] args) {

        SynchronizedExample s = new SynchronizedExample();

        new Thread(s::foo).start();
        new Thread(s::foo).start();
        new Thread(s::foo).start();
        new Thread(s::foo).start();

    }

}
