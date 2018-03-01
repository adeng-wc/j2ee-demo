package com.adeng.jmx.standard;

import javax.management.Attribute;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import java.lang.management.ManagementFactory;

/**
 * 代理类
 * Created by w11282 on 2018/1/25.
 */
public class StandardAgent {

    public static void main(String[] args) throws InterruptedException, MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanException, ReflectionException, InvalidAttributeValueException, InstanceNotFoundException, AttributeNotFoundException {

        //通过创建 MBeanServer 作为Mbean容器
        /**
         *  MBeanServerFactory.createMBeanServer() 与  ManagementFactory.getPlatformMBeanServer()
         *  这两个方法的区别：
         *      ManagementFactory.getPlatformMBeanServer()中会调用
         *          platformMBeanServer = MBeanServerFactory.createMBeanServer();
         */
//        MBeanServer mBeanServer = MBeanServerFactory.createMBeanServer();
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        String domain = mBeanServer.getDefaultDomain();
        String managedResourceClassName = "com.wengcheng.jmx.standard.Car";
        ObjectName objectName = new ObjectName(domain + ":type=" + managedResourceClassName);

/*            //格式为 “域名:name=MBean名称”
            ObjectName objectName = new ObjectName("jmxBean:name=car");
            // create Mbean and register MBean
            ObjectInstance objectInstance = mBeanServer.registerMBean(new Car(), objectName);*/

//            ObjectInstance objectInstance = mBeanServer.createMBean(managedResourceClassName, objectName);
        ObjectInstance objectInstance = mBeanServer.registerMBean(new Car(), objectName);

        Attribute colorAttribute = new Attribute("Color", "blue");
        mBeanServer.setAttribute(objectName, colorAttribute);
        System.out.println(mBeanServer.getAttribute(objectName, "Color"));
        mBeanServer.invoke(objectName, "drive", null, null);

        Thread.sleep(60 * 60 * 1000);

    }
}

