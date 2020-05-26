package com.mark.observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @author Mark
 * @date 2020/5/26 15:11
 */
public class GuavaEvent {

    @Subscribe
    public void subscribe(String str) {
        //业务逻辑
        System.out.println("执行subscribe方法，传入的参数是：" + str);
    }
}
