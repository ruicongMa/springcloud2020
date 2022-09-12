package com.moe.juc2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Mark
 * @date 2022/5/18 15:02
 */
public class TestAtomic {

    static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        int tmp = atomicInteger.get();
        new Thread(() -> {
            atomicInteger.incrementAndGet();
        }).start();
        System.out.println(tmp);
        System.out.println(atomicInteger.get());
    }
}
