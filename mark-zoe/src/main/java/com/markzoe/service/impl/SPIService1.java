package com.markzoe.service.impl;

import com.markzoe.service.SPITest;

/**
 * @author Mark
 * @date 2021/8/4 23:32
 */
public class SPIService1 implements SPITest {

    @Override
    public void say() {
        System.out.println("spi service one...");
    }
}
