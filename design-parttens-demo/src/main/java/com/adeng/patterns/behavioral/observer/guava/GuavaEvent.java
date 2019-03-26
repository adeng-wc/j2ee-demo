package com.adeng.patterns.behavioral.observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @author hzwengcheng 2019-03-26 15:48
 */
public class GuavaEvent {

    @Subscribe
    public void sub(String str) {
        System.out.println("sub:" + str);
    }
}


