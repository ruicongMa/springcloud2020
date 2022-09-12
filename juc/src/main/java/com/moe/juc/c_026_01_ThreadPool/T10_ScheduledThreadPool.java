package com.moe.juc.c_026_01_ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark
 * @date 2022/5/17 15:00
 */
public class T10_ScheduledThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
        service.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName() + " => " + System.currentTimeMillis());
            try {
                TimeUnit.MILLISECONDS.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, 2000, TimeUnit.MILLISECONDS);
    }
}
