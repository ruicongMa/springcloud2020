package com.moe.juc.c_020;

import java.util.concurrent.Semaphore;

/**
 * @author Mark
 * @date 2022/5/16 0:50
 */
public class T11_TestSemaphore {

    public static void main(String[] args) {
        // 允许两个线程同时执行
        Semaphore s = new Semaphore(2);
        // Semaphore s = new Semaphore(2, true);
        // 允许一个线程同时执行
        // Semaphore s = new Semaphore(1);
        new Thread(() -> {
            try {
                s.acquire();
                System.out.println("T1 start...");
                Thread.sleep(2000);
                System.out.println("T1 end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }).start();

        new Thread(() -> {
            try {
                s.acquire();
                System.out.println("T2 start...");
                Thread.sleep(2000);
                System.out.println("T2 end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }).start();
    }
}
