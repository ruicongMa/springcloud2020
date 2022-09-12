package com.moe.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Mark
 * @date 2022/5/17 10:08
 */
public class T04_00_BlockingQueue {

    static BlockingQueue<String> q1 = new ArrayBlockingQueue(1);
    static BlockingQueue<String> q2 = new ArrayBlockingQueue(1);

    public static void main(String[] args) {
        char[] aI = "ABCDEFG".toCharArray();
        char[] aC = "1234567".toCharArray();

        new Thread(() -> {
            for (char c : aI) {
                try {
                    System.out.print(c);
                    q1.put("ok");
                    q2.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : aC) {
                try {
                    q1.take();
                    System.out.print(c);
                    q2.put("ok");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();
    }
}
