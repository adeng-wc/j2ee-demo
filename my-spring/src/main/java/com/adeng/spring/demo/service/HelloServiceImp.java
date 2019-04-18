package com.adeng.spring.demo.service;


import com.adeng.spring.framework.annotation.MyService;

/**
 * @author hzwengcheng 2019-03-29 15:13
 */
@MyService
public class HelloServiceImp implements HelloService {

    @Override
    public String hello() {
        return null;
    }
}
