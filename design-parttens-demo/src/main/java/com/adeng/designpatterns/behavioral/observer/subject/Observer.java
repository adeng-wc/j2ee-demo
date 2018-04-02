package com.adeng.designpatterns.behavioral.observer.subject;

import com.adeng.designpatterns.behavioral.observer.core.Event;

public class Observer {

    public void advice(Event e){
        System.out.println("=========触发事件，打印日志========\n" + e);

    }

}
