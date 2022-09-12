package com.moe.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 曾经的面试题：（淘宝？）
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 *
 * @author Mark
 * @date 2022/5/16 11:03
 */
public class T04_NotifyFreeLock2 {

    List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T04_NotifyFreeLock2 c = new T04_NotifyFreeLock2();

        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("t2 启动");
                while (c.size() != 5) {
                    c2.await();
                }
                System.out.println("t2 结束");
                c1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("t1 启动");
                for (int i = 1; i <= 10; i++) {
                    c.add(new Object());
                    System.out.println("add " + i);
                    if (c.size() == 5) {
                        c2.signal();
                        c1.await();
                    }
                    // TimeUnit.SECONDS.sleep(1);
                }
                System.out.println("t1 结束");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();
    }
}
