package com.adeng.jmx.model;

import javax.management.Attribute;
import javax.management.Descriptor;
import javax.management.MBeanException;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.modelmbean.DescriptorSupport;
import javax.management.modelmbean.ModelMBean;
import javax.management.modelmbean.ModelMBeanAttributeInfo;
import javax.management.modelmbean.ModelMBeanInfo;
import javax.management.modelmbean.ModelMBeanInfoSupport;
import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.management.modelmbean.RequiredModelMBean;
import java.lang.management.ManagementFactory;

/**
 * 模板类型的代理
 * <p>
 * Created by w11282 on 2018/1/26.
 */
public class ModelAgent {

    private static String MANAGED_CLASS_NAME = "com.adeng.jmx.model.ModelCar";
    private static String MANAGED_PATH = "com.adeng.jmx.model";

    /**
     * 设置允许暴露的方法，和属性
     *
     * @param inMbeanObjectName
     * @return
     */
    private static ModelMBeanInfo createModelMBeanInfo(ObjectName inMbeanObjectName) {
        ModelMBeanInfo mBeanInfo = null;
        ModelMBeanAttributeInfo[] attributeInfos = new ModelMBeanAttributeInfo[1];
        ModelMBeanOperationInfo[] operationInfos = new ModelMBeanOperationInfo[3];

        attributeInfos[0] = new ModelMBeanAttributeInfo(
                "Color", "java.lang.String", "the color",
                true, true, false, null);

        operationInfos[0] = new ModelMBeanOperationInfo(
                "drive", "the drive method", null,
                "void", MBeanOperationInfo.ACTION, null
        );

        operationInfos[1] = new ModelMBeanOperationInfo(
                "getColor", "the getColor method", null,
                "java.long.String", MBeanOperationInfo.ACTION, null
        );

        Descriptor setColorDesc = new DescriptorSupport(new String[]{
                "name=setColor", "descriptortype=operation", "class=" + MANAGED_CLASS_NAME, "role=operation"});

        MBeanParameterInfo[] setColorParams = new MBeanParameterInfo[]{
                new MBeanParameterInfo("new color", "java.lang.String", "new color value")
        };

        operationInfos[2] = new ModelMBeanOperationInfo(
                "setColor", "the setColor method", setColorParams,
                "java.long.String", MBeanOperationInfo.ACTION, setColorDesc);

        return new ModelMBeanInfoSupport(MANAGED_CLASS_NAME, null, attributeInfos, null, operationInfos, null);
    }

    /**
     * RequiredModelMBean 是 ModelMBean 的默认实现，
     * Tomcat中没有使用ModelMBean，而是自定义了一个BaseModelMBean
     *
     * @param objectName
     * @return
     * @throws MBeanException
     */
    private static ModelMBean createModelMbean(ObjectName objectName) throws MBeanException {
        //创建ModelMBeanInfo信息
        ModelMBeanInfo modelMBeanInfo = createModelMBeanInfo(objectName);
        return new RequiredModelMBean(modelMBeanInfo);
    }

    public static void main(String[] args) throws Exception {

        /* 获取 MBeanServer */
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        /* 创建 ObjectName */
        ObjectName objectName = new ObjectName(MANAGED_PATH + ":type=MyModelCar");

        /* 创建ModelMBean */
        ModelMBean modelMbean = createModelMbean(objectName);

        //绑定资源，注册MBean
        ModelCar modelCar = new ModelCar();
        /*设置对象的实例句柄，我们将根据该句柄执行此 ModelMBean 管理接口（MBeanInfo 和 Descripto）中的所有方法*/
        modelMbean.setManagedResource(modelCar, "ObjectReference");
        mBeanServer.registerMBean(modelMbean, objectName);

        //通过代码来管理，操作
        Attribute colorAttribute = new Attribute("Color", "blue");
        mBeanServer.setAttribute(objectName, colorAttribute);
        String color = (String) mBeanServer.getAttribute(objectName, "Color");
        System.out.println("color:" + color);

        colorAttribute = new Attribute("Color", "green");
        mBeanServer.setAttribute(objectName, colorAttribute);
        color = (String) mBeanServer.getAttribute(objectName, "Color");
        System.out.println("color:" + color);

        mBeanServer.invoke(objectName, "drive", null, null);

        Thread.sleep(60 * 60 * 1000);
    }
}


