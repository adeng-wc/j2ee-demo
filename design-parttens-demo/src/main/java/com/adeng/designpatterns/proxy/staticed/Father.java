package com.adeng.designpatterns.proxy.staticed;

import com.adeng.designpatterns.proxy.Person;

public class Father {

    //持有代理人的引用
    private Person person;

    //没办法扩展
    public Father(Person person){
        this.person = person;
    }

    //目标对象的引用给拿到
    public void findJob(){

        System.out.println("根据你的要求找");

        this.person.findJob();

        System.out.println("工作是否满意");
    }

}

