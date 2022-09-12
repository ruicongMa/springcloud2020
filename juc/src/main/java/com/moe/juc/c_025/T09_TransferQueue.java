package com.moe.juc.c_025;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * @author Mark
 * @date 2022/5/16 22:59
 */
public class T09_TransferQueue {

    public static void main(String[] args) throws InterruptedException {
        TransferQueue<String> queue = new LinkedTransferQueue<>();

        new Thread(() -> {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(2);

        queue.transfer("aaa");

        // queue.put("bbb");

        // new Thread(() -> {
        //     try {
        //         System.out.println(queue.take());
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        // }).start();
        System.out.println("ok");
    }
}
