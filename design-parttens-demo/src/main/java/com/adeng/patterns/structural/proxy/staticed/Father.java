package com.adeng.patterns.structural.proxy.staticed;

import com.adeng.patterns.structural.proxy.Person;

/**
 * 代理类。  静态代理
 */
public class Father {

    /**
     * 持有代理人的引用
     */
    private Person person;

    /**
     * 缺点是 没办法扩展
     *
     * @param person
     */
    public Father(Person person) {
        this.person = person;
    }

    /**
     * 在调用 目标对象的方法之前可以做自己的额外逻辑处理
     */
    public void findJob() {

        System.out.println("根据你的要求找");

        this.person.findJob();

        System.out.println("工作是否满意");
    }

}

