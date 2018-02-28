package com.adeng.jmx.example.remote;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationListener;

/**
 * @Author: Adengdeng
 * @Date: Create in 下午11:30 2018
 */
public class ClientListener implements NotificationListener {

    private static void echo(String msg) {
        System.out.println(msg);
    }

    @Override
    public void handleNotification(Notification notification, Object handback) {
        echo("\nReceived notification:");
        echo("\tClassName: " + notification.getClass().getName());
        echo("\tSource: " + notification.getSource());
        echo("\tType: " + notification.getType());
        echo("\tMessage: " + notification.getMessage());

        if (notification instanceof AttributeChangeNotification) {
            AttributeChangeNotification acn =
                    (AttributeChangeNotification) notification;
            echo("\tAttributeName: " + acn.getAttributeName());
            echo("\tAttributeType: " + acn.getAttributeType());
            echo("\tNewValue: " + acn.getNewValue());
            echo("\tOldValue: " + acn.getOldValue());
        }
    }
}
