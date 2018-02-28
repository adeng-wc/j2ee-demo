package com.adeng.jmx.example.notifications;

import javax.management.Notification;
import javax.management.NotificationListener;

/**
 * @Author: Adengdeng
 * @Date: Create in 下午10:41 2018
 */
public class HelloListener implements NotificationListener {

    /**
     *
     * @param notification
     * @param handback 监听处理的目标对象
     */
    @Override
    public void handleNotification(Notification notification, Object handback) {

        if (handback instanceof Hello) {
            Hello hello = (Hello) handback;

            System.out.println("HelloListener收到通知："+ notification.getMessage());
        }
    }
}
