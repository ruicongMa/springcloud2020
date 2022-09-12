package com.moe.juc.c_026_01_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Mark
 * @date 2022/5/17 14:29
 */
public class T07_SingleThreadPool {

    public static void main(String[] args) {
        // 保证只有一个线程执行，也就是线程有执行顺序
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            service.execute(() -> {
                System.out.println(j + " " + Thread.currentThread().getName());
            });
        }
    }
}
