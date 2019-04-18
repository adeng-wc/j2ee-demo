package com.adeng.spring.demo;

import com.adeng.spring.demo.service.HelloService;
import com.adeng.spring.framework.context.MyApplicationContext;

/**
 * @author hzwengcheng 2019-04-18 15:16
 */
public class MyApplicationContextTest {

    public static void main(String[] args) {
        MyApplicationContext context = new MyApplicationContext("classpath:application.properties");
        try {
            context.getBean("demoAction");
            context.getBean(HelloService.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
