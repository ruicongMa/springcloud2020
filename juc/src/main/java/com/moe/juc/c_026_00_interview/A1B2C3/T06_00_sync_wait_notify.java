package com.moe.juc.c_026_00_interview.A1B2C3;

/**
 * @author Mark
 * @date 2022/5/17 0:51
 */
public class T06_00_sync_wait_notify {

    public static void main(String[] args) {
        final Object o = new Object();

        char[] aI = "ABCDEFG".toCharArray();
        char[] aC = "1234567".toCharArray();

        new Thread(() -> {
            synchronized (o) {
                for (char c : aI) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait(); //让出锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify(); //必须，否则无法停止程序
            }

        }, "t1").start();

        new Thread(() -> {
            synchronized (o) {
                for (char c : aC) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t2").start();
    }
}
