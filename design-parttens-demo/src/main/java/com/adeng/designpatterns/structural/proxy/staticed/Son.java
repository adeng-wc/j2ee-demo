package com.adeng.designpatterns.structural.proxy.staticed;

import com.adeng.designpatterns.structural.proxy.Person;

public class Son implements Person {


    @Override
    public void findJob() {
        System.out.println("找工作，钱多活少");
    }
}

