package com.moe.juc.c_020;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock还可以指定为公平锁
 *
 * @author Mark
 * @date 2022/5/15 22:26
 */
public class T05_ReentrantLock5 extends Thread {

    private static ReentrantLock lock = new ReentrantLock(true); // 参数为true表示为公平锁，请对比输出结果

    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        T05_ReentrantLock5 rl = new T05_ReentrantLock5();
        Thread t1 = new Thread(rl, "t1");
        Thread t2 = new Thread(rl, "t2");
        t1.start();
        t2.start();
    }
}
