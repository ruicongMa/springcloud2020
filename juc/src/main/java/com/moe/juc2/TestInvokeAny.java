package com.moe.juc2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Mark
 * @date 2022/5/18 9:20
 */
public class TestInvokeAny {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(() -> {
            System.out.println("1");
            return 1;
        });
        tasks.add(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("2");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 2;
        });
        Integer result = executorService.invokeAny(tasks);
        System.out.println(result);

    }

}
