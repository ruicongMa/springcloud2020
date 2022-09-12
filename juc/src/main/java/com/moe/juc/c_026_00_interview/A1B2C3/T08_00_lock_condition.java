package com.moe.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Mark
 * @date 2022/5/17 1:03
 */
public class T08_00_lock_condition {

    public static void main(String[] args) {

        char[] aI = "ABCDEFG".toCharArray();
        char[] aC = "1234567".toCharArray();

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                for (char c : aI) {
                    System.out.print(c);
                    condition.signal();
                    condition.await();
                }
                condition.signal();
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
                    condition.signal();
                    condition.await();
                }
                condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }
}
