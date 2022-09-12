package com.moe.juc.c_020;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark
 * @date 2022/5/15 23:11
 */
public class T07_TestCyclicBarrier01 implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private int index;

    public T07_TestCyclicBarrier01(CyclicBarrier cyclicBarrier, int index) {
        this.cyclicBarrier = cyclicBarrier;
        this.index = index;
    }

    public void run() {
        try {
            if (index % 2 == 0) {
                TimeUnit.SECONDS.sleep(2);
            }
            System.out.println("index: " + index);
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            public void run() {
                System.out.println("所有特工到达屏障，准备开始执行秘密任务");
            }
        });
        for (int i = 0; i < 10; i++) {
            new Thread(new T07_TestCyclicBarrier01(cyclicBarrier, i)).start();
        }
        // cyclicBarrier.await();
        // System.out.println("全部到达屏障....");
    }
}
