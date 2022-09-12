package com.moe.juc.c_026_01_ThreadPool;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark
 * @date 2022/5/17 11:14
 */
public class T05_00_HelloThreadPool {

    static class Task implements Runnable {

        private int i;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Task " + i);
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "Task{" +
                    "i=" + i +
                    '}';
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, 4,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                // new ThreadPoolExecutor.AbortPolicy()); // 100任务直接抛异常
                // new ThreadPoolExecutor.DiscardOldestPolicy()); // 任务2丢弃
                // new ThreadPoolExecutor.DiscardPolicy()); // 100任务丢弃
                new ThreadPoolExecutor.CallerRunsPolicy()); // 丢给调用者执行，比如当前例子，调用者就是主线程

        for (int i = 0; i < 8; i++) {
            tpe.execute(new Task(i));
        }

        System.out.println(tpe.getQueue()); // 查看任务队列信息

        tpe.execute(new Task(100));

        System.out.println(tpe.getQueue());

        tpe.shutdown(); // 在关闭之前，需要把任务（正在执行的任务和任务队里中的任务）都执行完才关闭
    }
}
