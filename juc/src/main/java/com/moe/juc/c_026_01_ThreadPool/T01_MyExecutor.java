package com.moe.juc.c_026_01_ThreadPool;

import java.util.concurrent.Executor;

/**
 * 认识Executor
 *
 * @author Mark
 * @date 2022/5/17 10:33
 */
public class T01_MyExecutor implements Executor {

    // 定义和行为分开，把任务交给用户，具体怎么执行需要用户去实现
    public static void main(String[] args) {
        new T01_MyExecutor().execute(() -> System.out.println("hello executor"));
    }

    @Override
    public void execute(Runnable command) {
        //new Thread(command).run();
        command.run();
    }

}
