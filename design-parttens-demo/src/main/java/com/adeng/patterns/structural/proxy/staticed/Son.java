package com.adeng.patterns.structural.proxy.staticed;

import com.adeng.patterns.structural.proxy.Person;

/**
 * 被代理类
 *
 */
public class Son implements Person {

    @Override
    public void findJob() {
        System.out.println("找工作，钱多活少");
    }
}

