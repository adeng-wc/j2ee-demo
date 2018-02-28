package com.adeng.jmx.example.mbeans.mxbean;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: Adengdeng
 * @Date: Create in 下午8:44 2018
 */
public class MXBeanMain {

    public static void main(String[] args) throws Exception {

        MBeanServer mbs =
                ManagementFactory.getPlatformMBeanServer();

        /* 使用无注解的 */
        ObjectName mxbeanName = new ObjectName("com.adeng.jmx.example.mbeans.mxbean:type=QueueSampler");

        Queue<String> queue = new ArrayBlockingQueue<>(10);
        queue.add("Request-1");
        queue.add("Request-2");
        queue.add("Request-3");

        QueueSampler mxbean = new QueueSampler(queue);

        mbs.registerMBean(mxbean, mxbeanName);

        /* 使用注解的 */
        ObjectName pcName = new ObjectName("com.adeng.jmx.example.mbeans.mxbean:type=PersonController");
        PersonController controller = new PersonController();
        controller.add("name1");

//        controller.add(new Person("name2"));
        mbs.registerMBean(controller, pcName);

        System.out.println("Waiting...");
        Thread.sleep(Long.MAX_VALUE);
    }
}
