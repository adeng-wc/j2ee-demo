package com.adeng.jmx.example.notifications;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @Author: Adengdeng
 * @Date: Create in 下午8:27 2018
 */
public class StandardMain {

    public static void main(String[] args) throws Exception {

        /* 获取平台的MBeanServer对象，如果没有会调用MBeanServerFactory.createMBeanServer()创建 */
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        /* ObjectName对象是用来标识MBean。
         *	使用字符串[domainName]:property=value[,property=value]*
         */
        ObjectName name = new ObjectName("com.adeng.jmx.example.mbeans.standard:type=Hello");

        Hello hello = new Hello();

        /* 注册监听, 第三个参数是消息接听处理的目标对象*/
        hello.addNotificationListener(new HelloListener(), null, new Hello());

        mBeanServer.registerMBean(hello, name);

        System.out.println("一直等待......");
        Thread.sleep(Long.MAX_VALUE);
    }
}
