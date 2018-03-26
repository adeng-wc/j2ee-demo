package com.adeng.spring.demo.di;

/**
 * Printer类是一个有状态的类，counter字段记录访问次数
 *
 * @author
 * @create 2018-03-25 下午5:12
 */
public class Printer {
    private int counter = 0;
    public void print(String type) {
        System.out.println(type + " printer: " + counter++);
    }
}
