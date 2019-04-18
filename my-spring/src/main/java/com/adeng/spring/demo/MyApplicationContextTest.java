package com.adeng.spring.demo;

import com.adeng.spring.framework.context.MyApplicationContext;

/**
 * @author hzwengcheng 2019-04-18 15:16
 */
public class MyApplicationContextTest {

    public static void main(String[] args) {
        MyApplicationContext context = new MyApplicationContext("classpath:application.properties");
        context.getBean("demoAction");
        System.out.println(context);
    }
}
