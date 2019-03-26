package com.adeng.patterns.behavioral.observer.guava;

import com.google.common.eventbus.EventBus;

/**
 * @author hzwengcheng 2019-03-26 15:48
 */
public class GuavaEventTest {

    public static void main(String[] args) {
        EventBus bus = new EventBus();
        bus.register(new GuavaEvent());
        bus.post("nima ");
    }
}
