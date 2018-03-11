package com.adeng.designpatterns.proxy.staticed;

public class StaticProxyTest {

    public static void main(String[] args) {

        //只能帮人找工作
        Father father = new Father(new Son());

        father.findJob();

    }
}
