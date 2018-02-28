package com.adeng.jmx.example.remote;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

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
        ObjectName name = new ObjectName("com.adeng.jmx.example.remote:type=Hello");

        Hello hello = new Hello();

        mBeanServer.registerMBean(hello, name);

        /* 注册 QueueSampler*/
        ObjectName mxbeanName = new ObjectName("com.adeng.jmx.example.remote:type=QueueSampler");

        Queue<String> queue = new ArrayBlockingQueue<>(10);
        queue.add("Request-1");
        queue.add("Request-2");
        queue.add("Request-3");

        QueueSampler mxbean = new QueueSampler(queue);

        mBeanServer.registerMBean(mxbean, mxbeanName);

        //通过客户端程序进行远程调用
        //这个步骤很重要。注册一个端口，绑定url后用于客户端通过rmi方式连接JMXConnectorServer
        LocateRegistry.createRegistry(9999);

        // URL路径的结尾可以随意指定，但如果需要用Jconsole来进行连接，则必须使用jmxrmi
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");

        JMXConnectorServer jcs =
                JMXConnectorServerFactory.newJMXConnectorServer(url, null, mBeanServer);

        System.out.println("begin rmi start");

        jcs.start();
        System.out.println("rmi start");

        System.out.println("一直等待......");
        Thread.sleep(Long.MAX_VALUE);
    }
}
