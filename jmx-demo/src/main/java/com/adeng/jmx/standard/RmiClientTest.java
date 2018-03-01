package com.adeng.jmx.standard;


import javax.management.Attribute;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * 客户端，与Agent进行远程连接
 * Created by w11282 on 2018/2/23.
 */
public class RmiClientTest {

    public static void main(String[] args) throws Exception {

        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);

        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
        ObjectName mbeanName = new ObjectName("jmxBean:name=car");

        System.out.println("Domains ......");
        String[] domains = mbsc.getDomains();

        for (String str : domains) {
            System.out.println("domains = " + str);
        }

        System.out.println("MBean cout = " + mbsc.getMBeanCount());
        /* 设置制定Mbean的特地属性值
         *  对属性进行赋值和取值，通过setAttribute和getAttribute。
         *  属性的首字母要大写。
         */
        mbsc.setAttribute(mbeanName, new Attribute("Color", "123"));
        String color = (String) mbsc.getAttribute(mbeanName, "Color");
        System.out.println("color = " + color);

        /*
         *   对资源里面的方法进行操作有两种方式：
         *       一是通过代理直接调用方法；
         *       二是通过JAVA的反射注入的方式进行方法的调用。
         */
        CarMBean proxy = MBeanServerInvocationHandler
                .newProxyInstance(mbsc, mbeanName, CarMBean.class, false);
        proxy.drive();
        System.out.println("Color = " + proxy.getColor());
        proxy.reset();
        /* invoke调用bean的方法，只针对非设置属性的方法，
         * 例如invoke不能对getName方法进行调用。
         * 对setColor(String s)方法也是不能调用的。
         */
        mbsc.invoke(mbeanName, "drive", null, null);
        mbsc.invoke(mbeanName, "helloWorld", new String[]{"321"}, new String[]{"java.lang.String"});
//        mbsc.invoke(mbeanName,"helloWorld", null,null);
    }
}

