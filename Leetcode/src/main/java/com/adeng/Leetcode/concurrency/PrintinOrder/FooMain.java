package com.adeng.Leetcode.concurrency.PrintinOrder;

/**
 * @author hzwengcheng 2019-08-07 14:00
 */
public class FooMain {

    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread t1 = new Thread(() -> {
            try {
                foo.first(() -> System.out.println("one"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread t2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.println("two"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread t3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.println("three"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t3.start();
        t2.start();
        t1.start();
    }
}
