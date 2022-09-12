package com.moe.juc.c_020;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Mark
 * @date 2022/5/15 22:55
 */
public class T07_TestCyclicBarrier {

    public static void main(String[] args) {
        // CyclicBarrier barrier = new CyclicBarrier(20);
        CyclicBarrier barrier = new CyclicBarrier(20, () -> System.out.println("满人"));
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
