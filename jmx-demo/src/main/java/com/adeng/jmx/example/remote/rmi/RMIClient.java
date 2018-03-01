package com.adeng.jmx.example.remote.rmi;

import com.adeng.jmx.example.remote.ClientListener;
import com.adeng.jmx.example.remote.HelloMBean;
import com.adeng.jmx.example.remote.QueueSample;
import com.adeng.jmx.example.remote.QueueSamplerMXBean;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.Thread.sleep;

/**
 * Java RMI( Java Remote Method Invocation )
 *
 * @Author: Adengdeng
 * @Date: Create in 下午11:35 2018
 */
public class RMIClient {

    private static void echo(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) throws Exception {

        echo("\nCreate an RMI connector client and connect it to the RMI connector server");

        /*
            客户端定义JMXServiceURL，它表示连接服务器所在的位置。
            此URL允许客户端从本地主机的端口9999上运行的RMI注册表中检索RMI连接器服务器存根jmxrmi。
         */
        JMXServiceURL url =
                new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");

        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);


        /*
            然后通过调用JMXConnector实例jmxc的getMBeanServerConnection（）方法创建一个名为mbsc的MBeanServerConnection实例。

            连接器客户端现在连接到由JMX代理创建的MBean服务器，并且可以注册MBean并对它们执行操作，并且连接对于两端保持完全透明。
         */
        echo("\nGet an MBeanServerConnection");
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();


        /* Get domains from MBeanServer */
        echo("\nDomains:");
        String domains[] = mbsc.getDomains();
        Arrays.sort(domains);
        for (String domain : domains) {
            echo("\tDomain = " + domain);
        }

        // Get MBeanServer's default domain
        echo("\nMBeanServer default domain = " + mbsc.getDefaultDomain());

        // Get MBean count
        echo("\nMBean count = " + mbsc.getMBeanCount());

        // Query MBean names
        echo("\nQuery MBeanServer MBeans:");
        Set<ObjectName> names =
                new TreeSet<ObjectName>(mbsc.queryNames(null, null));
        for (ObjectName name : names) {
            echo("\tObjectName = " + name);
        }

        // ----------------------
        // Manage the Hello MBean
        // ----------------------
        echo("\n>>> Perform operations on Hello MBean <<<");

        /* 通过代理执行远程MBean的操作 */

        ObjectName mbeanName = new ObjectName("com.adeng.jmx.example.remote:type=Hello");

        HelloMBean mbeanProxy =
                JMX.newMBeanProxy(mbsc, mbeanName, HelloMBean.class, true);

        /* 创建监听器 */
        ClientListener listener = new ClientListener();

        echo("\nAdd notification listener...");
        mbsc.addNotificationListener(mbeanName, listener, null, null);

        echo("\nCacheSize = " + mbeanProxy.getCacheSize());
        mbeanProxy.setCacheSize(150);

        echo("\nWaiting for notification...");
        sleep(2000);

        echo("\nCacheSize = " + mbeanProxy.getCacheSize());

        echo("\nInvoke sayHello() in Hello MBean...");
        mbeanProxy.sayHello();

        echo("\nInvoke add(2, 3) in Hello MBean...");
        echo("\nadd(2, 3) = " + mbeanProxy.add(2, 3));


        // ------------------------------
        // Manage the QueueSampler MXBean
        // ------------------------------
        echo("\n>>> Perform operations on QueueSampler MXBean <<<");

        ObjectName mxbeanName =
                new ObjectName("com.adeng.jmx.example.remote:type=QueueSampler");

        QueueSamplerMXBean mxbeanProxy =
                JMX.newMXBeanProxy(mbsc, mxbeanName, QueueSamplerMXBean.class);

        QueueSample queue1 = mxbeanProxy.getQueueSample();
        echo("\nQueueSample.Date = " + queue1.getDate());
        echo("QueueSample.Head = " + queue1.getHead());
        echo("QueueSample.Size = " + queue1.getSize());

        echo("\nInvoke clearQueue() in QueueSampler MXBean...");
        mxbeanProxy.clearQueue();

        QueueSample queue2 = mxbeanProxy.getQueueSample();
        echo("\nQueueSample.Date = " + queue2.getDate());
        echo("QueueSample.Head = " + queue2.getHead());
        echo("QueueSample.Size = " + queue2.getSize());

        echo("\nClose the connection to the server");
        jmxc.close();
        echo("\nBye! Bye!");

    }

}
