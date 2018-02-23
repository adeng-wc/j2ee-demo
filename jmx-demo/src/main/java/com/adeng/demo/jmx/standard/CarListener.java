package com.adeng.demo.jmx.standard;

import javax.management.Notification;
import javax.management.NotificationListener;

/**
 * 创建消息监听
 * Created by w11282 on 2018/2/23.
 */
public class CarListener implements NotificationListener{

    public void handleNotification(Notification notification, Object handback) {

        if (handback instanceof Car) {
            Car car = (Car) handback;
            car.helloWorld(notification.getMessage());
        }
    }
}

