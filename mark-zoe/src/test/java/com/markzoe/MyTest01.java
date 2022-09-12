package com.markzoe;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark
 * @date 2022/5/12 15:40
 */
public class MyTest01 {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        System.out.println("start...");
        service.scheduleWithFixedDelay(() -> {
            System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 2, 3, TimeUnit.SECONDS);
        System.out.println("moe...");
    }
}
