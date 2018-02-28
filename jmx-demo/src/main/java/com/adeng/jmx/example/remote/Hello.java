package com.adeng.jmx.example.remote;


import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 * @Author: Adengdeng
 * @Date: Create in 下午8:27 2018
 */
public class Hello extends NotificationBroadcasterSupport implements HelloMBean {

    private String name = "HelloName";
    private int cacheSize = 100;

    /* 通知序列号 */
    private long sequenceNumber = 1;

    public void sayHello() {
        System.out.println("Hello, world!");
    }

    public int add(int x, int y) {
        return x + y;
    }

    public String getName() {
        return name;
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public synchronized void setCacheSize(int size) {

        int oldSize = this.cacheSize;
        this.cacheSize = size;

        System.out.println("old is " + oldSize + " new is " + this.cacheSize);


        /* 构建通知对象 */
        Notification n = new AttributeChangeNotification(this,
                sequenceNumber++, System.currentTimeMillis(),
                "CacheSize changed", "CacheSize", "int",
                oldSize, this.cacheSize);

        /* 调用NotificationBroadcasterSupport.sendNotification 发送通知*/
        sendNotification(n);

        System.out.println("发送AttributeChangeNotification "+ size);
    }


    /* 定义可能发送消息的类型 */
    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {

        String[] types = new String[]{
                AttributeChangeNotification.ATTRIBUTE_CHANGE
        };

        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo info =
                new MBeanNotificationInfo(types, name, description);

        System.out.println("invoik getNotificationInfo");

        return new MBeanNotificationInfo[]{info};
    }
}

