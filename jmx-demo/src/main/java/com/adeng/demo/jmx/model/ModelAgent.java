package com.adeng.demo.jmx.model;

import javax.management.Attribute;
import javax.management.Descriptor;
import javax.management.MBeanException;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.modelmbean.DescriptorSupport;
import javax.management.modelmbean.ModelMBean;
import javax.management.modelmbean.ModelMBeanAttributeInfo;
import javax.management.modelmbean.ModelMBeanInfo;
import javax.management.modelmbean.ModelMBeanInfoSupport;
import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.management.modelmbean.RequiredModelMBean;

/**
 * 模板类型的代理
 * <p>
 * Created by w11282 on 2018/1/26.
 */
public class ModelAgent {

    private String MANAGED_CLASS_NAME = "com.adeng.demo.jmx.model.ModelCar";
    private MBeanServer mBeanServer = null;

    public ModelAgent() {
        this.mBeanServer = MBeanServerFactory.createMBeanServer();
    }

    public MBeanServer getmBeanServer() {
        return mBeanServer;
    }

    private ObjectName createObjectName(String name) throws MalformedObjectNameException {
        return new ObjectName(name);
    }

    /**
     * 设置允许暴露的方法，和属性
     *
     * @param inMbeanObjectName
     * @param inObjectName
     * @return
     */
    private ModelMBeanInfo createModelMBeanInfo(ObjectName inMbeanObjectName, String inObjectName) {
        ModelMBeanInfo mBeanInfo = null;
        ModelMBeanAttributeInfo[] attributeInfos = new ModelMBeanAttributeInfo[1];
        ModelMBeanOperationInfo[] operationInfos = new ModelMBeanOperationInfo[3];

        attributeInfos[0] = new ModelMBeanAttributeInfo("Color", "java.lang.String", "the color", true, true, false, null);
        operationInfos[0] = new ModelMBeanOperationInfo("drive", "the drive method", null, " void", MBeanOperationInfo.ACTION, null);
        operationInfos[1] = new ModelMBeanOperationInfo("getColor", "the getColor method", null, "java. long.String", MBeanOperationInfo.ACTION, null);

        Descriptor setColorDesc = new DescriptorSupport(
                new String[]{
                "name = setColor",
                "descriptorType = operation",
                "class=" + MANAGED_CLASS_NAME,
                "role = operation "});

        MBeanParameterInfo[] setColorParams = new MBeanParameterInfo[]{
                new MBeanParameterInfo("new color","java.lang.String","new color value")};

        operationInfos[2] = new ModelMBeanOperationInfo(
                "setColor","the setColor method",
                setColorParams,"java.long.String",
                MBeanOperationInfo.ACTION, setColorDesc);

        return new ModelMBeanInfoSupport(MANAGED_CLASS_NAME, null, attributeInfos, null, operationInfos, null);
    }

    /**
     * RequiredModelMBean 是 ModelMBean 的默认实现，
     * Tomcat中没有使用ModelMBean，而是自定义了一个BaseModelMBean
     *
     * @param objectName
     * @param mbeanName
     * @return
     * @throws MBeanException
     */
    private ModelMBean createModelMbean(ObjectName objectName, String mbeanName) throws MBeanException {
        //创建ModelMBeanInfo信息
        ModelMBeanInfo modelMBeanInfo = createModelMBeanInfo(objectName, mbeanName);
        return new RequiredModelMBean(modelMBeanInfo);
    }

    public static void main(String[] args) throws Exception {
        ModelAgent modelAgent = new ModelAgent();
        MBeanServer mBeanServer = modelAgent.getmBeanServer();
        ModelCar modelCar = new ModelCar();
        String demoin = mBeanServer.getDefaultDomain();

        //创建ObjectName，用于识别MBeanServer管理中的MBean
        ObjectName objectName = modelAgent.createObjectName(demoin + ":type=MyModelCar");
        //自定义管理的名称，这里暂时没用到
        String mBeanName = "MyModelCarMBean";
        /**
         * 创建ModelMBean
         *  创建ModelMBeanInfo信息
         *       创建ModelMBeanAttributeInfo[]
         *       创建ModelMBeanOperationInfo[]
         */
        ModelMBean modelMbean = modelAgent.createModelMbean(objectName, mBeanName);

        //绑定资源，注册MBean
        modelMbean.setManagedResource(modelCar, "ObjectReference");
        mBeanServer.registerMBean(modelMbean, objectName);

        //管理，操作
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


