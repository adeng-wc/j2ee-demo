package com.adeng.spring.demo.ioc;

import com.adeng.spring.demo.HelloApi;

/**
 * @author
 * @create 2018-03-25 下午1:44
 */
public class HelloImpl implements HelloApi {
    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }
}
