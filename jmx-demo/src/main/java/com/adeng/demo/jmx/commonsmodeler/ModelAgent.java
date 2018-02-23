package com.adeng.demo.jmx.commonsmodeler;

import org.apache.commons.modeler.ManagedBean;
import org.apache.commons.modeler.Registry;

import javax.management.Attribute;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.modelmbean.InvalidTargetObjectTypeException;
import javax.management.modelmbean.ModelMBean;
import java.io.InputStream;
import java.net.URL;

/**
 * 模板类型的代理
 *
 * 需要依赖
 <dependency>
 <groupId>commons-modeler</groupId>
 <artifactId>commons-modeler</artifactId>
 <version>2.0.1</version>
 </dependency>
 *
 * Created by w11282 on 2018/1/26.
 */
public class ModelAgent {

    private String MANAGED_CLASS_NAME = "com.adeng.demo.jmx.commonsmodeler.ModelCar";
    private MBeanServer mBeanServer = null;
    private Registry registry = null;

    public ModelAgent() throws Exception {
        registry = createRegistry();
        this.mBeanServer = registry.getMBeanServer();
    }

    private Registry createRegistry() throws Exception {
        String path = "mbeans-descriptors.xml";
  /*      String path2 = System.getProperty("user.dir") + File.separator + "com" + File.separator + "wengcheng" +
                File.separator + "jmx" + File.separator + "commonsmodeler"+File.separator+"mbeans-descriptors.xml";

        //path不以‘/’开头时，默认是从此类所在的包下获取资源
        System.out.println(this.getClass().getResource(""));
        System.out.println(this.getClass().getResource("/"));
        System.out.println(path2);
        //path  以‘/’开头时，默认是从classpath的根下获取资源
        System.out.println(this.getClass().getClassLoader().getResource(path2));*/

        URL url = this.getClass().getResource(path);

        InputStream inputStream = url.openStream();

        Registry.loadRegistry(inputStream);

        inputStream.close();

        return Registry.getRegistry();
    }

    public MBeanServer getmBeanServer() {
        return mBeanServer;
    }

    private ObjectName createObjectName(String name) throws MalformedObjectNameException {
        return new ObjectName(name);
    }

    private ModelMBean createModelMbean(String mbeanName) throws MBeanException, InvalidTargetObjectTypeException, InstanceNotFoundException {
        ManagedBean managedBean = registry.findManagedBean(mbeanName);
        ModelMBean mBean = managedBean.createMBean();
        return mBean;
    }

    public static void main(String[] args) throws Exception {
        ModelAgent modelAgent = new ModelAgent();
        MBeanServer mBeanServer = modelAgent.getmBeanServer();
        ModelCar modelCar = new ModelCar();

        ObjectName objectName = modelAgent.createObjectName(mBeanServer.getDefaultDomain() + ":type=ModelCar");
        String mBeanName = "ModelCar";

        ModelMBean modelMbean = modelAgent.createModelMbean(mBeanName);

        //绑定资源，注册MBean
        modelMbean.setManagedResource(modelCar, "ObjectReference");
        mBeanServer.registerMBean(modelMbean, objectName);

        //管理，操作
        Attribute colorAttribute = new Attribute("color", "blue");
        mBeanServer.setAttribute(objectName, colorAttribute);
        String color = (String) mBeanServer.getAttribute(objectName, "color");
        System.out.println("color:" + color);

        colorAttribute = new Attribute("color", "green");
        mBeanServer.setAttribute(objectName, colorAttribute);
        color = (String) mBeanServer.getAttribute(objectName, "color");
        System.out.println("color:" + color);

        mBeanServer.invoke(objectName, "drive", null, null);

    }
}

