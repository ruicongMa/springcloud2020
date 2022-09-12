package com.moe.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition本质是锁资源上不同的等待队列
 *
 * @author Mark
 * @date 2022/5/17 1:05
 */
public class T09_00_lock_condition {

    public static void main(String[] args) {

        char[] aI = "ABCDEFG".toCharArray();
        char[] aC = "1234567".toCharArray();

        Lock lock = new ReentrantLock();
        Condition conditionT1 = lock.newCondition();
        Condition conditionT2 = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                for (char c : aI) {
                    System.out.print(c);
                    conditionT2.signal();
                    conditionT1.await();
                }
                conditionT2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                for (char c : aC) {
                    System.out.print(c);
                    conditionT1.signal();
                    conditionT2.await();
                }
                conditionT1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }
}
