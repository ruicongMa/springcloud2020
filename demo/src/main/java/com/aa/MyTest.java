package com.aa;

import com.example.demo.BaseService;

/**
 * @author Mark
 * @date 2021/9/16 18:29
 */
public class MyTest {

    public static void main(String[] args) {
        BaseService baseService = new BaseService();


        Thread.interrupted();
        Thread.currentThread().isInterrupted();
        new Thread().isInterrupted();
    }
}
