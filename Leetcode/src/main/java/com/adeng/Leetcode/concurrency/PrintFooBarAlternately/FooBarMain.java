package com.adeng.Leetcode.concurrency.PrintFooBarAlternately;

/**
 * @author hzwengcheng 2019-08-07 16:50
 */
public class FooBarMain {

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(10);
        Thread t1 = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        Thread t2 = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
