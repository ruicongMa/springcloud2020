package com.moe.juc.c_020;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Mark
 * @date 2022/5/15 23:46
 */
public class T10_TestReadWriteLock {
    static Lock lock = new ReentrantLock();
    static int value;

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock) {
        lock.lock();
        try {
            //模拟读取操作
            Thread.sleep(1000);
            System.out.println("read value=[" + value + "] over!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock, int v) {
        lock.lock();
        try {
            //模拟写操作
            Thread.sleep(1000);
            value += v;
            System.out.println("write => v=[" + v + "]，value=[" + value + "] over!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        // Runnable readR = () -> read(lock);
        Runnable readR = () -> read(readLock);
        // Runnable writeR = () -> write(lock, new Random().nextInt(100));
        Runnable writeR = () -> write(writeLock, new Random().nextInt(100));
        for (int i = 0; i < 10; i++) new Thread(readR).start();
        for (int i = 0; i < 5; i++) new Thread(writeR).start();
    }
}