package com.moe.juc2;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * @author Mark
 * @date 2022/5/18 18:31
 */
public class TestException {

    static class MyThreadPoolExecutor extends ThreadPoolExecutor {

        public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                                    BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory,
                                    RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);
            // do something
            // int i = 10 / 0;
        }
    }

    public static void main(String[] args) throws IOException {
        MyThreadPoolExecutor executor = new MyThreadPoolExecutor(1, 1, 0,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(8),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                            @Override
                            public void uncaughtException(Thread t, Throwable e) {
                                System.out.println("出错了。。。" + e);
                            }
                        });
                        return thread;
                    }
                }, new ThreadPoolExecutor.CallerRunsPolicy());

        executor.execute(() -> {
            int i = 10 / 0;
            System.out.println("任务1 =>" + Thread.currentThread().getName());
        });

        executor.execute(() -> {
            System.out.println("任务2 =>" + Thread.currentThread().getName());
            int i = 10 / 0;
        });

        executor.execute(() -> {
            System.out.println("任务3 =>" + Thread.currentThread().getName());
            int i = 10 / 0;
        });

        executor.execute(() -> {
            System.out.println("任务4 =>" + Thread.currentThread().getName());
            int i = 10 / 0;
        });

        // test();
    }

    public static void test() {
        try {
            try {
                System.out.println(10 / 0);
            } catch (Exception e) {
                // throw e;
            } finally {
                System.out.println("inner....");
            }
            System.out.println("xxxxxx");
        } catch (Exception e) {
            // throw e;
        } finally {
            System.out.println("outer....");
        }
        System.out.println("ooooooo");
    }
}
