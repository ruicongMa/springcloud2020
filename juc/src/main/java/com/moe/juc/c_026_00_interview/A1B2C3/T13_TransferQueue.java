package com.moe.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @author Mark
 * @date 2022/5/17 10:22
 */
public class T13_TransferQueue {

    public static void main(String[] args) {
        char[] aC = "ABCDEFG".toCharArray();
        char[] aI = "1234567".toCharArray();

        TransferQueue<Character> queue = new LinkedTransferQueue<>();

        new Thread(() -> {
            try {
                for (char c : aI) {
                    System.out.print(queue.take());
                    queue.transfer(c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                for (char c : aC) {
                    queue.transfer(c);
                    System.out.print(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
