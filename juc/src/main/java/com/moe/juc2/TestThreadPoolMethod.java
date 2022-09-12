package com.moe.juc2;

import java.util.concurrent.*;

/**
 * @author Mark
 * @date 2022/5/18 13:55
 */
public class TestThreadPoolMethod {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true); // 设置守护线程，当主线程结束后，守护线程也就结束了
            // 默认线程工厂创建的线程设置为非守护线程，在这只是为了测试 shutdown和awaitTermination方法
            return thread;
        });

        executorService.submit(() -> {
            System.out.println("begin");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end");
        });

        executorService.shutdown(); // 如果线程是守护线程，不写下边的方法，则不会等待任务结束
        executorService.awaitTermination(1, TimeUnit.MINUTES); // 就算主线程结束，守护线程在结束的时候，也需要等待任务执行完
    }
}
