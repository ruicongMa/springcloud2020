package com.moe.juc.c_026_01_ThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 认识future
 * 异步
 *
 * @author Mark
 * @date 2022/5/17 11:11
 */
public class T06_00_Future {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        FutureTask<Integer> task = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(3);
            return 1000;
        }); //new Callable () { Integer call();}

        new Thread(task).start();

        System.out.println(task.get()); //阻塞
    }
}
