package com.adeng.jmx.standard;

import javax.management.Notification;
import javax.management.NotificationBroadcaster;
import javax.management.NotificationBroadcasterSupport;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;

/**
 * MBean之间通信使用Notification。
 *      {@link Notification} 相当于一个消息包。
 *      {@link NotificationBroadcaster} 相当于一个广播。
 *      {@link NotificationListener} 监听器。
 *      {@link NotificationFilter}  消息过滤器。
 *
 * Created by w11282 on 2018/2/23.
 */
public class Master extends NotificationBroadcasterSupport implements MasterMBean{

    private  int seq = 0;

    public void callCar() {
        //创建一个消息
        Notification notification =
                //通知名称；谁发起的通知；序列号；发起通知时间；发送的消息
                new Notification("Master.callCar", this, ++seq, System.currentTimeMillis(),"master call car");

        sendNotification(notification);
    }
}

