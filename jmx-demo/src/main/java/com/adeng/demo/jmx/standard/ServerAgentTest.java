package com.adeng.demo.jmx.standard;

import javax.management.MBeanServer;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;

/**
 * 不同方式访问JMX
 * Created by w11282 on 2018/2/23.
 */
public class ServerAgentTest {

    public static void main(String[] args) {

        try {
            //注册通过JConsole访问
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            ObjectName objectName = new ObjectName("jmxBean:name=car");
            Car car = new Car();
            ObjectInstance objectInstance = mBeanServer.registerMBean(car, objectName);

//            Thread.sleep(60*60*1000);

            //通过JMX提供的工具页访问
            ObjectName adapterName = new ObjectName("HtmlAdaptorServerTest:name=htmladapter,port=8082");

        /*     * HtmlAdaptorServer这个类决定MBean的管理界面，这里是普通的Html
             * pom中引入依赖：
                     <dependency>
                  <groupId>com.sun.jdmk</groupId>
                  <artifactId>jmxtools</artifactId>
                  <version>1.2.1</version>
                  <type>pom</type>
                </dependency>

                这个jar下载需要sum公司认证
             */

 /*           HtmlAdaptorServer adaptorServer = new HtmlAdaptorServer();
            mBeanServer.registerMBean(adaptorServer, adapterName);
            adaptorServer.start();*/


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

            /*  注册 Master的MBean */
            Master master = new Master();
            ObjectInstance objectInstance2 =
                    mBeanServer.registerMBean(master, new ObjectName("jmxBean:name=master"));
            /* 在Master上添加CarListener的监听对象 */
            master.addNotificationListener(new CarListener(), null, car);
            Thread.sleep(60 * 60 * 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
