package com.moe.juc.c_025;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author Mark
 * @date 2022/5/16 22:56
 */
public class T08_SynchronousQueue {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new SynchronousQueue<>(); //容量为0
        new Thread(() -> {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // queue.add("aaa"); // 直接报异常，容量已满
        queue.put("bbb"); // 阻塞等待消费者消费
        System.out.println(queue.size());
    }
}
