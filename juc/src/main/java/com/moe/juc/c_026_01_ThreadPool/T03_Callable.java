package com.moe.juc.c_026_01_ThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 认识Callable，对Runnable进行了扩展
 * 对Callable的调用，可以有返回值
 *
 * @author Mark
 * @date 2022/5/17 11:05
 */
public class T03_Callable {

    public static void main(String[] args) {
        Callable<String> callable = () -> {
            TimeUnit.SECONDS.sleep(2);
            return "ok";
        };

        FutureTask<String> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();

        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
