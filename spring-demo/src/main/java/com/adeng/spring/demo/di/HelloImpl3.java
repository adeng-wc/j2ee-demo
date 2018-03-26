package com.adeng.spring.demo.di;

import com.adeng.spring.demo.HelloApi;

/**
 * @author
 * @create 2018-03-25 下午1:52
 */
public class HelloImpl3 implements HelloApi {
    private String message;
    private int index;

    //@java.beans.ConstructorProperties({"message", "index"})
    public HelloImpl3(String message, int index) {
        this.message = message;
        this.index = index;
    }

    @Override
    public void sayHello() {
        System.out.println(index + ":" + message);
    }
}