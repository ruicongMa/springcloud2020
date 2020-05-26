package com.mark.observer.guava;

import com.google.common.eventbus.EventBus;

/**
 * @author Mark
 * @date 2020/5/26 15:12
 */
public class Test {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("Mark");
    }
}
