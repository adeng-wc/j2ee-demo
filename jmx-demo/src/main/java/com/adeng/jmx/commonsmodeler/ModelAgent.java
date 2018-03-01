package com.adeng.jmx.commonsmodeler;

import org.apache.commons.modeler.ManagedBean;
import org.apache.commons.modeler.Registry;

import javax.management.Attribute;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.modelmbean.InvalidTargetObjectTypeException;
import javax.management.modelmbean.ModelMBean;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
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

    private String MANAGED_CLASS_NAME = "com.adeng.jmx.commonsmodeler.ModelCar";

    private static Registry registry = null;

    static {
        registry = createRegistry();
    }

    private static Registry createRegistry() {
        String path = "mbeans-descriptors.xml";
        try {
            URL url = ModelAgent.class.getResource(path);
            InputStream inputStream = url.openStream();
            Registry.loadRegistry(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Registry.getRegistry();
    }

    private static ModelMBean createModelMbean(String mbeanName) throws MBeanException, InvalidTargetObjectTypeException, InstanceNotFoundException {
        ManagedBean managedBean = registry.findManagedBean(mbeanName);
        ModelMBean mBean = managedBean.createMBean();
        return mBean;
    }

    public static void main(String[] args) throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        ObjectName objectName = new ObjectName("com.wengcheng.jmx.commonsmodeler:type=ModelCar");

        ModelMBean modelMbean = createModelMbean("ModelCar");

        //绑定资源，注册MBean
        ModelCar modelCar = new ModelCar();
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

